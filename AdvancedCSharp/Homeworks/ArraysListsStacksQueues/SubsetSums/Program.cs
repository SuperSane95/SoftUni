using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubsetSums
{
    class Program
    {
        static void Main(string[] args)
        {
            throw new NotImplementedException();
            //TODO
            int result = int.Parse(Console.ReadLine());
            string[] numbers = Console.ReadLine().Split(' ');
            List<int> list = new List<int>();
            foreach(var item in numbers)
            {
                list.Add(int.Parse(item));
            }
            for(int i = 0; i<list.Count; i++)
            {
                int num = list.ElementAt(i);
                if(num == result)
                {
                    Console.WriteLine("%d = %d", num, numbers);
                }
                else if(num < result)
                {
                    int count = 0;
                    while(num != 11 || num < 11)
                    {

                    }
                }
            }
        }
    }
}
