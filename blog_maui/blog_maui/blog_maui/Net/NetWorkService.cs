using System.Text.Json;

namespace blog_maui.Net
{
    public class NetWorkService
    {
        public static HttpClient _client;
        public static JsonSerializerOptions _serializerOptions;

        public NetWorkService()
        {
            _client = new HttpClient();
            _serializerOptions = new JsonSerializerOptions
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
                WriteIndented = true
            };
        }
    }
}
