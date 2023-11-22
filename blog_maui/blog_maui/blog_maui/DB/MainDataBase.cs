using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace blog_maui.DB
{
    public class MainDataBase
    {
        public static SQLiteAsyncConnection Database;

        public MainDataBase()
        {

        }

        /**
         * Autor:zhangyi
         * Date:2023.11.22
         * Describe:初始化数据库
         * Parameter:无
         * **/
        public async Task Init()
        {
            if (Database is not null) return;

            Database = new SQLiteAsyncConnection(Constants.DatabasePath, Constants.Flags);
        }
    }
}
