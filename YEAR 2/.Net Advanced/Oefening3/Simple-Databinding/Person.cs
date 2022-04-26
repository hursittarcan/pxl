using System.ComponentModel;

namespace Simple_Databinding
{
    public class Person : INotifyPropertyChanged
    {
        private string _firstName;
        public string FirstName
        {
            get => _firstName; //same as 'get { return _firstName; }'
            set
            {
                _firstName = value;
                OnPropertyChanged(nameof(FirstName));
                OnPropertyChanged(nameof(FullName));
            }
        }

        private string _lastName;
        public string LastName
        {
            get => _lastName; //same as 'get { return _lastName; }'
            set
            {
                _lastName = value;
                OnPropertyChanged(nameof(LastName));
                OnPropertyChanged(nameof(FullName));
            }
        }
        public string FullName => $"{_firstName} {_lastName}";

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

    }
}

