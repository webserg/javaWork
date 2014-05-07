using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace CsharpWorks
{
    class ProductNullable
    {
        public string Name { get; private set; }
        public decimal? price;
        public decimal? Price
        {
            get { return price; }
            private set { price = value; }
        }
        public ProductNullable(string name, decimal price)
        {
            Name = name;
            Price = price;
        }
        ProductNullable()
        {
        }
        public static List<ProductNullable> GetSampleProducts()
        {
            return new List<ProductNullable>
		{
			new ProductNullable { Name="Company", Price = 9.99m },
			new ProductNullable { Name="Assassins", Price = 14.99m },
			new ProductNullable { Name="Frogs", Price = 13.99m },
			new ProductNullable { Name="Sweeney Todd", Price = 10.99m},
            new ProductNullable { Name="www", Price = null}
		};
        }
        public override string ToString()
        {
            return string.Format("{0}: {1}", Name, Price);
        }
        static void Main()
        {
            Console.WriteLine("hello, world C");
            List<ProductNullable> products = ProductNullable.GetSampleProducts();

            foreach (ProductNullable product in products.OrderBy(p => p.Name))
            {
                Console.WriteLine(product);
            }
            Console.WriteLine();
            foreach (ProductNullable product in products)
                Console.WriteLine(product);

            products.Sort((first, second) => first.Name.CompareTo(second.Name));
            Console.WriteLine();
            foreach (ProductNullable product in products)
                Console.WriteLine(product);

            //print with conditions using delegates
            Console.WriteLine("print with conditions using delegates");
            List<ProductNullable> products2 = ProductNullable.GetSampleProducts();
            Predicate<ProductNullable> test = delegate(ProductNullable p)
            { return p.Price > 10m; };
            List<ProductNullable> matches = products2.FindAll(test);
            Action<ProductNullable> print = delegate(ProductNullable p)
            { Console.WriteLine(p); };
            matches.ForEach(print);

            //------------------------------------
            Console.WriteLine("print with conditions using delegates one line");
            List<ProductNullable> products3 = ProductNullable.GetSampleProducts();
            products3.FindAll(delegate(ProductNullable p) { return p.Price > 10; })
            .ForEach(delegate(ProductNullable p) { Console.WriteLine(p); });

            //-----------c#3 with lambda
            Console.WriteLine("print with conditions using lambda");
            List<ProductNullable> products4 = ProductNullable.GetSampleProducts();
            foreach (ProductNullable product in products4.Where(p => p.Price > 10))
            {
                Console.WriteLine(product);
            }

            //---------c# with nullable
            Console.WriteLine("print with nullable");
            List<ProductNullable> products5 = ProductNullable.GetSampleProducts();
            foreach (ProductNullable product in products.Where(p => p.Price == null))
            {
                Console.WriteLine(product);
            }
        }
    }
}
