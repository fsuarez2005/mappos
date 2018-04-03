using System;
using System.Data.SQLite;
using Microsoft.Win32.SafeHandles;
using System.Runtime.InteropServices;
using System.Collections.Generic;

namespace mappos.POSClasses
{
    
    class ItemDatabaseClient
    {

        private string filename;
        private SQLiteConnection connection;

        private string generateConnectionString()
        {

            return "";
        }

        
        public ItemDatabaseClient() {}
        
        public void SetupFile()
        {
            // setup SQLite file

            SQLiteConnection.CreateFile(this.filename);
        }

        public void SendCommand()
        {



        }

        public void Open()
        {
            this.connection = new SQLiteConnection("Data Source: " + this.filename + ";Version:3;");
        }

        public void Close()
        {
            this.connection.Close();

        }


        public void Add() { }


        public void Remove() { }

        public void Modify() { }


        public void Get() { }

        // stub
        public Item GetItemByUPCA(string upca)
        {


            return null;
        }

        /**
         * <summary>Search for items looking for phrase in item description.</summary>
         * <returns>List of stocking item numbers used to get item object.</returns>
         */
        public List<int> SearchByDescription(string phrase)
        {
            return null;
        }

    }
}
