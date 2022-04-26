using System.Collections.Generic;

namespace StudentData
{
    public class StateRepository
    {
        public IList<State> GetAll()
        {
            var states = new List<State>
            {
                new State
                {
                    Name = "Limburg",
                    Code = "Lim"
                },
                new State
                {
                    Name = "Brabant",
                    Code = "Bra"
                },
                new State
                {
                    Name = "Luik",
                    Code = "Lui"
                }
            };
            return states;
        }
    }
}