using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mappos
{
    public class UPCA
    {
        private String upca;


        public UPCA(String upca) {
            this.upca = upca;
        }

        public Boolean isLengthValid()
        {
            return (this.upca.Length == 12);
        }


        // STUB validate UPC
        public Boolean isValid()
        {



            return false;


        }

        // STUB calculateChecksum
        public short calculateChecksum()
        {
            return 0;
        }
        

        // STUB converts to shorter UPC-E
        public void convertToUPCE() { }

    }
}
