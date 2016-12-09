#region Using directives

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

#endregion

namespace ConsoleApplication1
{
    class Program
    {
        static string[] eTypes = { "none", "simple", "index", "nested index" };

        static void Main(string[] args)
        {
            foreach (string eType in eTypes)
            {
                try
                {
                    Console.WriteLine("Main() try Block reached");
                    Console.WriteLine("ThrowException(\"{0}\") called", eType);
                    ThrowException(eType);
                    Console.WriteLine("Main() try");
                }
                catch (System.IndexOutOfRangeException e)
                {
                    Console.WriteLine("{0}", e.Message);
                }
                catch
                {
                    Console.WriteLine("Main() general");
                }
                finally
                {
                    Console.WriteLine("Main() finally");
                }
                Console.WriteLine();
            }
            Console.ReadKey();
        }

        static void ThrowException(string exceptionType)
        {
            Console.WriteLine("ThrowEx(\"{0}\") reached", exceptionType);
            switch (exceptionType)
            {
                case "none":
                    Console.WriteLine("Not");
                    break;
                case "simple":
                    Console.WriteLine("Thowing");
                    throw (new System.Exception());
                    break;
                case "index":
                    Console.WriteLine("Thrpwing Index");
                    eTypes[4] = "error";
                    break;
                case "nested index":
                    try
                    {
                        Console.WriteLine("ThrowExc()" + "try ");
                        ThrowException("index");
                    }
                    catch
                    {
                        Console.WriteLine("Throw");
                    }
                    finally
                    {
                        Console.WriteLine("block");
                    }
                    break;
            }
        }
    }
}