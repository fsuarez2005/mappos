using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;



namespace mappos.POSClasses
{

    /**
        <summary>Merchandise</summary>
        
    */
    class Item
    {
        // returns string to create an item table 
        // stub
        public static string getSQLModelCreationString()
        {
            return "";

        }

        private UPCA upc;

        /**
            <summary>Internal item number</summary>

        */
        private int itemNumber;
        private string description;
        private string name;
        private double cost;
        private double price;
        private string locationCache;
        private List<string> keywords;


        public void setName(string name)
        {
            this.name = name;
        }

        public string getName()
        {
            return this.name;
        }


        public string convertToSQLString()
        {

            return "";

        }
    }
}
