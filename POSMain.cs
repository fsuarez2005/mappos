﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mappos
{
    public partial class POSMain : Form
    {
        private POSClasses.ItemDatabaseClient connection;



        public POSMain()
        {
            InitializeComponent();
        }

        private void textEntry_KeyPress(object sender, KeyPressEventArgs e)
        {
            //TextBox t = (TextBox)sender;
            listRegisterLog.Items.Add(e.KeyChar);
            
            //t.Text = e.KeyChar.ToString();

            
        }

        private void POSMain_Load(object sender, EventArgs e)
        {
            this.connection = new POSClasses.ItemDatabaseClient();
            this.connection.Open();



        }
    }
}
