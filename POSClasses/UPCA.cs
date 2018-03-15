using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SQLite;


namespace mappos
{
    public class UPCA
    {
        private int upcaLength = 12;

        // try to save as much space as possible
        private byte[] upca;

        public void setValue(String upcaString)
        {

            for (int n = 0; n < upcaString.Length; n++)
            {
                String upca_digit_string = upcaString[n].ToString();

                int upca_digit = int.Parse(upca_digit_string);



                // go through each number in upc an convert it to byte type
                // the digit would only be 0 to 9 so a byte would be big enough
                this.upca[n] = (byte)upca_digit;

            }



        }


        public UPCA() {
            this.upca = new byte[upcaLength];
        }


        public void displayByteView()
        {
            foreach (byte n in this.upca)
            {
                Console.Write(n);



            }



        }

        public Boolean isLengthValid()
        {
            //return (this.upca.Length == 12);
            
            return false;
        }


        // STUB validate UPC
        public Boolean isValid()
        {



            return (this.calculateChecksum() == this.upca[11]);


        }

        // STUB calculateChecksum
        public int calculateChecksum()
        {
            // https://en.wikipedia.org/wiki/Check_digit#UPC

            int checksum = 0;

            // odd-digits
            checksum =
                this.upca[0] +
                this.upca[2] +
                this.upca[4] +
                this.upca[6] +
                this.upca[8] +
                this.upca[10];

            checksum = checksum * 3;

            // even digits
            checksum =
                checksum +
                this.upca[1] +
                this.upca[3] +
                this.upca[5] +
                this.upca[7] +
                this.upca[9];

            checksum %= 10;

            if (checksum != 0)
            {
                checksum = 10 - checksum;

            }




            return checksum;
        }
        

        // STUB converts to shorter UPC-E
        public void convertToUPCE() { }

    }
}
