package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumsAPI {

        REGISTERSUCCESSFUL ("api/register"),
        REGISTERUNSUCCESSFUL ("api/register"),
        URL_API ("/api"),
        LOGINSUCCESSFUL ("/api/login"),
        LOGINUNSUCCESSFUL ("api/login"),
        BASE_PATH ("/"),
        BASE_URI ("https://reqres.in");

        private String url;

    }
