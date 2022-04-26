using System.Windows;

namespace Simple_Databinding
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            var person = new Person
            {
                FirstName = "<Enter first name>",
                LastName = "<Enter last name>"
            }; 
           
            //Set the DataContext of the Window. 
            DataContext = person;
        }

        private void closeButton_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
