using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SQLite;


namespace mappos
{
    class DatabaseTest
    {

        public void test1()
        {

            String dbfilename = "testdatabase.sqlite3";


            // create sqlite file
            SQLiteConnection.CreateFile(dbfilename);
            // connect to file

            using (SQLiteConnection dbconn = new SQLiteConnection("Data Source: " + dbfilename + ";Version:3;"))
            {
                



            }


                Console.WriteLine("test1");


        }


    }
}
