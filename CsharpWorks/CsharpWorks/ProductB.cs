using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace CsharpWorks
{
    class ProductB
    {
        public string Name { get; private set; }
        public decimal Price { get; private set; }
        public ProductB(string name, decimal price)
        {
            Name = name;
            Price = price;
        }
        ProductB()
        {
        }
        public static List<ProductB> GetSampleProducts()
        {
            return new List<ProductB>
		{
			new ProductB { Name="Company", Price = 9.99m },
			new ProductB { Name="Assassins", Price=14.99m },
			new ProductB { Name="Frogs", Price=13.99m },
			new ProductB { Name="Sweeney Todd", Price=10.99m}
		};
        }
        public override string ToString()
        {
            return string.Format("{0}: {1}", Name, Price);
        }
        static void Main()
        {
            Console.WriteLine("hello, world B");
            List<ProductB> products = ProductB.GetSampleProducts();
            //delegate
            products.Sort(delegate(ProductB first, ProductB second) 

                { return first.Name.CompareTo(second.Name); }
            
                );
            
            foreach (ProductB product in products)
                Console.WriteLine(product);
        }
    }
}
