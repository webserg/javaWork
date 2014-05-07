using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace CsharpWorks
{
    class ProductC
    {
        public string Name { get; private set; }
        public decimal Price { get; private set; }
        public ProductC(string name, decimal price)
        {
            Name = name;
            Price = price;
        }
        ProductC()
        {
        }
        public static List<ProductC> GetSampleProducts()
        {
            return new List<ProductC>
		{
			new ProductC { Name="Company", Price = 9.99m },
			new ProductC { Name="Assassins", Price=14.99m },
			new ProductC { Name="Frogs", Price=13.99m },
			new ProductC { Name="Sweeney Todd", Price=10.99m}
		};
        }
        public override string ToString()
        {
            return string.Format("{0}: {1}", Name, Price);
        }
        static void Main()
        {
            Console.WriteLine("hello, world C");
            List<ProductC> products = ProductC.GetSampleProducts();

            foreach (ProductC product in products.OrderBy(p => p.Name))
            {
                Console.WriteLine(product);
            }
            Console.WriteLine();
            foreach (ProductC product in products)
                Console.WriteLine(product);

            products.Sort((first, second) => first.Name.CompareTo(second.Name));
            Console.WriteLine();
            foreach (ProductC product in products)
                Console.WriteLine(product);

            //print with conditions using delegates
            Console.WriteLine("print with conditions using delegates");
            List<ProductC> products2 = ProductC.GetSampleProducts();
            Predicate<ProductC> test = delegate(ProductC p)
            { return p.Price > 10m; };
            List<ProductC> matches = products2.FindAll(test);
            Action<ProductC> print = delegate(ProductC p)
            { Console.WriteLine(p); };
            matches.ForEach(print);

            //------------------------------------
            Console.WriteLine("print with conditions using delegates one line");
            List<ProductC> products3 = ProductC.GetSampleProducts();
            products3.FindAll(delegate(ProductC p) { return p.Price > 10; })
            .ForEach(delegate(ProductC p) { Console.WriteLine(p); });

            //-----------c#3 with lambda
            Console.WriteLine("print with conditions using lambda");
            List<ProductC> products4 = ProductC.GetSampleProducts();
            foreach (ProductC product in products4.Where(p => p.Price > 10))
            {
                Console.WriteLine(product);
            }
        }
    }
}
