using System.Linq;
using System.Windows;
using System.Windows.Controls;

namespace StudentData
{
	public partial class MainWindow : Window
	{
		public MainWindow()
		{
			InitializeComponent();

            var stateRepository = new StateRepository();
            var studentRepository = new StudentRepositoy();

		    statesComboBox.ItemsSource = stateRepository.GetAll();

            var allStudents = studentRepository.GetAll();
		    studentsListBox.ItemsSource = allStudents;         
            detailGrid.DataContext = allStudents.First();
		}

	    private void StudentsListBox_OnSelectionChanged(object sender, SelectionChangedEventArgs e)
	    {
	        detailGrid.DataContext = studentsListBox.SelectedItem;
	    }
	}
}