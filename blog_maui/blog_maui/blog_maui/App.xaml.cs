using blog_maui.DB;

namespace blog_maui
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();
            Init();
        }

        private async void Init() 
        {
            MainDataBase mainDataBase = new MainDataBase();
            await mainDataBase.Init();
            MainPage = new AppShell();
        }
    }
}