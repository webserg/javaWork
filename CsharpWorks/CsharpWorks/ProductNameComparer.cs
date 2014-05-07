using System.Collections;
using Product;
class ProductNameComparer : IComparer
{
public int Compare(object x, object y)
{
Product first = (Product)x;
Product second = (Product)y;
return first.Name.CompareTo(second.Name);
}
}