const fetch = require('cross-fetch');
const axios = require('axios').default;
const yargs = require('yargs');
const chalk = require('chalk');
yargs.version('1.1.0');

const log =
    require('simple-node-logger').createSimpleLogger('call.log');

async function getAllMovies(movieId = null, year = null, age = null){
    let url = 'http://localhost:3000/Movies/'
    if (movieId != null) {
        url += movieId;
    }
    else if(year != null) {
        url = 'http://localhost:3000/Movies?year=' + year;
    }
    else if(age != null) {
        url = 'http://localhost:3000/Movies?age=' + age;
    }
    console.log( chalk.blue.inverse("Result(s):"))

    setTimeout( () => {
        log.info('OUTGOING CALL TO URL: ', url);
    }, 1000);

    const response = await axios.get(url);
    const data = response.data;
    return data;
}

yargs.command({
    command: 'all',
    describe: chalk.green('Gets all items from the database'),
    handler(argv) {
        getAllMovies()
            .then(data => console.log(chalk.green.inverse(JSON.stringify(data))))
            .catch(error => console.log(chalk.red.inverse("Error, please try again!")))
    }
});

yargs.command({
    command: 'lookup',
    describe: chalk.red('Gets item with specified ID from the database'),
    builder: {
        identification: {
            describe: 'Give the ID of the movie',
            demandOption: true, // Required
            type: 'number'
        }
    },
    handler(argv) {
        getAllMovies(argv.identification)
            .then(data => console.log(chalk.green.inverse(JSON.stringify(data))))
            .catch(error => console.log(chalk.red.inverse("Error, please try again!")))
    }
});

yargs.command({
    command: 'year',
    describe: chalk.blue('Gets item(s) with specified year from the database'),
    builder: {
        year: {
            describe: 'Give the year of the movie(s)',
            demandOption: true, // Required
            type: 'number'
        }
    },
    handler(argv) {
        getAllMovies(null, argv.year)
            .then(data => console.log(chalk.green.inverse(JSON.stringify(data))))
            .catch(error => console.log(chalk.red.inverse("Error, please try again!")))
    }
});

yargs.command({
    command: 'age',
    describe: chalk.yellow('Gets item(s) with specified age from the database'),
    builder: {
        age: {
            describe: 'Give the viewers age of the movie(s)',
            demandOption: true, // Required
            type: 'number'
        }
    },
    handler(argv) {
        getAllMovies(null, null, argv.age)
            .then(data => console.log(chalk.green.inverse(JSON.stringify(data))))
            .catch(error => console.log(chalk.red.inverse("Error, please try again!")))
    }
});

yargs.parse();