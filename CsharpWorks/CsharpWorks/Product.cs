using System.Collections;
using System;
class Product
{
	public string Name { get; private set; }
	public decimal Price { get; private set; }
	public Product(string name, decimal price)
	{
		Name = name;
		Price = price;
	}
	Product()
	{
	}
	public static List<Product> GetSampleProducts()
	{
		return new List<Product>
		{
			new Product { Name="Company", Price = 9.99m },
			new Product { Name="Assassins", Price=14.99m },
			new Product { Name="Frogs", Price=13.99m },
			new Product { Name="Sweeney Todd", Price=10.99m}
		};
	}
	public override string ToString()
	{
		return string.Format("{0}: {1}", Name, Price);
	}
	static void Main() {
      Console.WriteLine("hello, world");
	  ArrayList products = Product.GetSampleProducts();
	  products.Sort(new ProductNameComparer());
	  foreach(Product product in products)
		Console.WriteLine(product);
    }
}
class ProductNameComparer : IComparer
{
public int Compare(object x, object y)
{
Product first = (Product)x;
Product second = (Product)y;
return first.Name.CompareTo(second.Name);
}
}
