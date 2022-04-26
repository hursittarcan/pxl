using System.Collections.Generic;

namespace StudentData
{
    public class StudentRepositoy
    {
        public IList<Student> GetAll()
        {
            var students = new List<Student>
            {
                new Student
                {
                    FirstName = "Wesley",
                    LastName = "Hendrikx",
                    Street = "Lectorstraat 10",
                    ZipCode = 3500,
                    City = "Hasselt",
                    StateCode = "Lim",
                    Phone = "011/775555",
                    Cell = "0484/111222"
                },
                new Student
                {
                    FirstName = "Marijke",
                    LastName = "Willems",
                    Street = "Stagecoordinatorstraat 77",
                    ZipCode = 4000,
                    City = "Luik",
                    StateCode = "Lui",
                    Phone = "043/775555"
                },
                new Student
                {
                    FirstName = "Kris",
                    LastName = "Hermans",
                    Street = "Onderzoekerstraat 31",
                    ZipCode = 3000,
                    City = "Leuven",
                    StateCode = "Bra",
                    Phone = "016/775555"
                }
            };
            return students;
        }
    }
}