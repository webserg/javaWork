using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace CsharpWorks
{
    class ProductLinq
    {
        public string Name { get; private set; }
        public decimal? price;
        public decimal? Price
        {
            get { return price; }
            private set { price = value; }
        }
        public ProductLinq(string name, decimal price)
        {
            Name = name;
            Price = price;
        }
        ProductLinq()
        {
        }
        public static List<ProductLinq> GetSampleProducts()
        {
            return new List<ProductLinq>
		{
			new ProductLinq { Name="Company", Price = 9.99m },
			new ProductLinq { Name="Assassins", Price = 14.99m },
			new ProductLinq { Name="Frogs", Price = 13.99m },
			new ProductLinq { Name="Sweeney Todd", Price = 10.99m},
            new ProductLinq { Name="www", Price = null}
		};
        }
        public override string ToString()
        {
            return string.Format("{0}: {1}", Name, Price);
        }
        static void Main()
        {
            Console.WriteLine("hello, world C");
            List<ProductLinq> products = ProductLinq.GetSampleProducts();

            foreach (ProductLinq product in products.OrderBy(p => p.Name))
            {
                Console.WriteLine(product);
            }
            Console.WriteLine();
            foreach (ProductLinq product in products)
                Console.WriteLine(product);

            products.Sort((first, second) => first.Name.CompareTo(second.Name));
            Console.WriteLine();
            foreach (ProductLinq product in products)
                Console.WriteLine(product);

            Console.WriteLine("-----------  linq   ------------");
            List<ProductLinq> products6 = ProductLinq.GetSampleProducts();
            var filtered = from ProductLinq p in products6
                           where p.Price > 10
                           select p;
            foreach (ProductLinq product in filtered)
            {
                Console.WriteLine(product);
            }          
        }
    }
}
