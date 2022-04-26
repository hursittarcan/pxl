using System.Windows;
using System.Windows.Controls;

namespace WPF_Databinding_Presidents
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            this.DataContext = "Please select a president";
        }
        private void PresidentsListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (presidentsListBox.SelectedItem == null) return;

            this.DataContext = (presidentsListBox.SelectedItem as President).Name;
        }
    }
}
