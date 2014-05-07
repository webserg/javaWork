using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace CsharpWorks
{
    class ProductA
    {
        public string Name { get; private set; }
        public decimal Price { get; private set; }
        public ProductA(string name, decimal price)
        {
            Name = name;
            Price = price;
        }
        ProductA()
        {
        }
        public static List<ProductA> GetSampleProducts()
        {
            return new List<ProductA>
		{
			new ProductA { Name="Company", Price = 9.99m },
			new ProductA { Name="Assassins", Price=14.99m },
			new ProductA { Name="Frogs", Price=13.99m },
			new ProductA { Name="Sweeney Todd", Price=10.99m}
		};
        }
        public override string ToString()
        {
            return string.Format("{0}: {1}", Name, Price);
        }
        static void Main()
        {
            Console.WriteLine("hello, world");
            List<ProductA> products = ProductA.GetSampleProducts();
            products.Sort(new ProductNameComparer());
            foreach (ProductA product in products)
                Console.WriteLine(product);
        }
    }
    class ProductNameComparer : IComparer<ProductA>
    {
        public int Compare(ProductA first, ProductA second)
        {
            return first.Name.CompareTo(second.Name);
        }
    }
}
