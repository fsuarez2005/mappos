using System;
using System.Data.SQLite;
using Microsoft.Win32.SafeHandles;
using System.Runtime.InteropServices;



namespace mappos.POSClasses
{
    
    class ItemServer : IDisposable
    {

        private string filename;
        private SQLiteConnection connection;

        // Flag: Has Dispose already been called?
        bool disposed = false;
        // Instantiate a SafeHandle instance.
        SafeHandle handle = new SafeFileHandle(IntPtr.Zero, true);

        // =================================================================
        // iDispose code

        // Public implementation of Dispose pattern callable by consumers.
        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }

        // Protected implementation of Dispose pattern.
        protected virtual void Dispose(bool disposing)
        {
            if (disposed)
                return;

            if (disposing)
            {
                handle.Dispose();
                // Free any other managed objects here.
                //

                connection.Close();
            }

            // Free any unmanaged objects here.
            //
            disposed = true;
        }

        // =================================================================


        public ItemServer() {}
        
        public void setupFile()
        {
            // setup SQLite file

            SQLiteConnection.CreateFile(this.filename);
        }

        public void sendCommand()
        {



        }

        public void openConnection()
        {
            this.connection = new SQLiteConnection("Data Source: " + this.filename + ";Version:3;");



        }


        public void add() { }


        public void remove() { }

        public void modify() { }


        public void get() { }

    }
}
