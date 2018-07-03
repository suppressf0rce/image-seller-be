package utils;

public class Constants {

    public static final String APP_NAME         = "ImageSeller";
    public static final String API_KEY          = "ImageSeller_APIKEY";
    public static final int TOKEN_EXPIRATION    = -1; //-1 For no expiration
    public static final String REST             = "http://localhost:8080/ImageSeller/rest/";
    public static final String WEBSITE          = "http://localhost:8080/ImageSeller/#!/";
    public static final String APP_LOGIN_PATH   = "http://localhost:8080/ImageSeller/#!/login";

    public static String getConfirmationMessage(String username, String link){
        return "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=US-ASCII\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"-moz-box-sizing: border-box; -ms-text-size-adjust: 100%; -webkit-box-sizing: border-box; -webkit-text-size-adjust: 100%; box-sizing: border-box; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 22px; margin: 0; min-width: 100%; padding: 0; text-align: left; width: 100% !important\">\n" +
                "  <style type=\"text/css\">\n" +
                "    body {\n" +
                "      width: 100% !important;\n" +
                "      min-width: 100%;\n" +
                "      -webkit-text-size-adjust: 100%;\n" +
                "      -ms-text-size-adjust: 100%;\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      -moz-box-sizing: border-box;\n" +
                "      -webkit-box-sizing: border-box;\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "\n" +
                "    .ExternalClass {\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    .ExternalClass {\n" +
                "      line-height: 100%;\n" +
                "    }\n" +
                "\n" +
                "    #backgroundTable {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      width: 100% !important;\n" +
                "      line-height: 100% !important;\n" +
                "    }\n" +
                "\n" +
                "    img {\n" +
                "      outline: none;\n" +
                "      text-decoration: none;\n" +
                "      -ms-interpolation-mode: bicubic;\n" +
                "      width: auto;\n" +
                "      max-width: 100%;\n" +
                "      clear: both;\n" +
                "      display: block;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      color: #1C232B;\n" +
                "      font-family: Helvetica, Arial, sans-serif;\n" +
                "      font-weight: normal;\n" +
                "      padding: 0;\n" +
                "      margin: 0;\n" +
                "      text-align: left;\n" +
                "      line-height: 1.3;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      font-size: 16px;\n" +
                "      line-height: 1.3;\n" +
                "    }\n" +
                "\n" +
                "    a:hover {\n" +
                "      color: #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    a:active {\n" +
                "      color: #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h1 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h2 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h3 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h4 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h5 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h6 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    table.button:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.tiny:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.tiny:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.tiny table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.small:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.small:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.small table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.large:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.large:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.large table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:hover table td {\n" +
                "      background: #1f54ed;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:visited table td {\n" +
                "      background: #1f54ed;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:active table td {\n" +
                "      background: #1f54ed;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:hover table a {\n" +
                "      border: 0 solid #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    table.button:visited table a {\n" +
                "      border: 0 solid #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    table.button:active table a {\n" +
                "      border: 0 solid #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:hover table td {\n" +
                "      background: #fefefe;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:hover table a {\n" +
                "      border: 0 solid #fefefe;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:hover table td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:active table td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary table td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.success:hover table td {\n" +
                "      background: #009482;\n" +
                "    }\n" +
                "\n" +
                "    table.button.success:hover table a {\n" +
                "      border: 0 solid #009482;\n" +
                "    }\n" +
                "\n" +
                "    table.button.alert:hover table td {\n" +
                "      background: #ff6131;\n" +
                "    }\n" +
                "\n" +
                "    table.button.alert:hover table a {\n" +
                "      border: 0 solid #ff6131;\n" +
                "    }\n" +
                "\n" +
                "    table.button.warning:hover table td {\n" +
                "      background: #fcae1a;\n" +
                "    }\n" +
                "\n" +
                "    table.button.warning:hover table a {\n" +
                "      border: 0px solid #fcae1a;\n" +
                "    }\n" +
                "\n" +
                "    .thumbnail:hover {\n" +
                "      box-shadow: 0 0 6px 1px rgba(78, 120, 241, 0.5);\n" +
                "    }\n" +
                "\n" +
                "    .thumbnail:focus {\n" +
                "      box-shadow: 0 0 6px 1px rgba(78, 120, 241, 0.5);\n" +
                "    }\n" +
                "\n" +
                "    body.outlook p {\n" +
                "      display: inline !important;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      font-weight: normal;\n" +
                "      font-size: 16px;\n" +
                "      line-height: 22px;\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 596px) {\n" +
                "      .small-float-center {\n" +
                "        margin: 0 auto !important;\n" +
                "        float: none !important;\n" +
                "        text-align: center !important;\n" +
                "      }\n" +
                "      .small-text-center {\n" +
                "        text-align: center !important;\n" +
                "      }\n" +
                "      .small-text-left {\n" +
                "        text-align: left !important;\n" +
                "      }\n" +
                "      .small-text-right {\n" +
                "        text-align: right !important;\n" +
                "      }\n" +
                "      .hide-for-large {\n" +
                "        display: block !important;\n" +
                "        width: auto !important;\n" +
                "        overflow: visible !important;\n" +
                "        max-height: none !important;\n" +
                "        font-size: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "      }\n" +
                "      table.body table.container .hide-for-large {\n" +
                "        display: table !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body table.container .row.hide-for-large {\n" +
                "        display: table !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body table.container .callout-inner.hide-for-large {\n" +
                "        display: table-cell !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body table.container .show-for-large {\n" +
                "        display: none !important;\n" +
                "        width: 0;\n" +
                "        mso-hide: all;\n" +
                "        overflow: hidden;\n" +
                "      }\n" +
                "      table.body img {\n" +
                "        width: auto;\n" +
                "        height: auto;\n" +
                "      }\n" +
                "      table.body center {\n" +
                "        min-width: 0 !important;\n" +
                "      }\n" +
                "      table.body .container {\n" +
                "        width: 95% !important;\n" +
                "      }\n" +
                "      table.body .columns {\n" +
                "        height: auto !important;\n" +
                "        -moz-box-sizing: border-box;\n" +
                "        -webkit-box-sizing: border-box;\n" +
                "        box-sizing: border-box;\n" +
                "        padding-left: 16px !important;\n" +
                "        padding-right: 16px !important;\n" +
                "      }\n" +
                "      table.body .column {\n" +
                "        height: auto !important;\n" +
                "        -moz-box-sizing: border-box;\n" +
                "        -webkit-box-sizing: border-box;\n" +
                "        box-sizing: border-box;\n" +
                "        padding-left: 16px !important;\n" +
                "        padding-right: 16px !important;\n" +
                "      }\n" +
                "      table.body .columns .column {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .columns .columns {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .column .column {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .column .columns {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .collapse .columns {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .collapse .column {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      td.small-1 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 8.333333% !important;\n" +
                "      }\n" +
                "      th.small-1 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 8.333333% !important;\n" +
                "      }\n" +
                "      td.small-2 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 16.666666% !important;\n" +
                "      }\n" +
                "      th.small-2 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 16.666666% !important;\n" +
                "      }\n" +
                "      td.small-3 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 25% !important;\n" +
                "      }\n" +
                "      th.small-3 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 25% !important;\n" +
                "      }\n" +
                "      td.small-4 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 33.333333% !important;\n" +
                "      }\n" +
                "      th.small-4 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 33.333333% !important;\n" +
                "      }\n" +
                "      td.small-5 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 41.666666% !important;\n" +
                "      }\n" +
                "      th.small-5 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 41.666666% !important;\n" +
                "      }\n" +
                "      td.small-6 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 50% !important;\n" +
                "      }\n" +
                "      th.small-6 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 50% !important;\n" +
                "      }\n" +
                "      td.small-7 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 58.333333% !important;\n" +
                "      }\n" +
                "      th.small-7 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 58.333333% !important;\n" +
                "      }\n" +
                "      td.small-8 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 66.666666% !important;\n" +
                "      }\n" +
                "      th.small-8 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 66.666666% !important;\n" +
                "      }\n" +
                "      td.small-9 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 75% !important;\n" +
                "      }\n" +
                "      th.small-9 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 75% !important;\n" +
                "      }\n" +
                "      td.small-10 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 83.333333% !important;\n" +
                "      }\n" +
                "      th.small-10 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 83.333333% !important;\n" +
                "      }\n" +
                "      td.small-11 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 91.666666% !important;\n" +
                "      }\n" +
                "      th.small-11 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 91.666666% !important;\n" +
                "      }\n" +
                "      td.small-12 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      th.small-12 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .columns td.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .column td.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .columns th.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .column th.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-1 {\n" +
                "        margin-left: 8.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-1 {\n" +
                "        margin-left: 8.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-2 {\n" +
                "        margin-left: 16.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-2 {\n" +
                "        margin-left: 16.666666% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-3 {\n" +
                "        margin-left: 25% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-3 {\n" +
                "        margin-left: 25% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-4 {\n" +
                "        margin-left: 33.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-4 {\n" +
                "        margin-left: 33.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-5 {\n" +
                "        margin-left: 41.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-5 {\n" +
                "        margin-left: 41.666666% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-6 {\n" +
                "        margin-left: 50% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-6 {\n" +
                "        margin-left: 50% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-7 {\n" +
                "        margin-left: 58.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-7 {\n" +
                "        margin-left: 58.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-8 {\n" +
                "        margin-left: 66.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-8 {\n" +
                "        margin-left: 66.666666% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-9 {\n" +
                "        margin-left: 75% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-9 {\n" +
                "        margin-left: 75% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-10 {\n" +
                "        margin-left: 83.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-10 {\n" +
                "        margin-left: 83.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-11 {\n" +
                "        margin-left: 91.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-11 {\n" +
                "        margin-left: 91.666666% !important;\n" +
                "      }\n" +
                "      table.body table.columns td.expander {\n" +
                "        display: none !important;\n" +
                "      }\n" +
                "      table.body table.columns th.expander {\n" +
                "        display: none !important;\n" +
                "      }\n" +
                "      table.body .right-text-pad {\n" +
                "        padding-left: 10px !important;\n" +
                "      }\n" +
                "      table.body .text-pad-right {\n" +
                "        padding-left: 10px !important;\n" +
                "      }\n" +
                "      table.body .left-text-pad {\n" +
                "        padding-right: 10px !important;\n" +
                "      }\n" +
                "      table.body .text-pad-left {\n" +
                "        padding-right: 10px !important;\n" +
                "      }\n" +
                "      table.menu {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.menu td {\n" +
                "        width: auto !important;\n" +
                "        display: inline-block !important;\n" +
                "      }\n" +
                "      table.menu th {\n" +
                "        width: auto !important;\n" +
                "        display: inline-block !important;\n" +
                "      }\n" +
                "      table.menu.vertical td {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu.vertical th {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu.small-vertical td {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu.small-vertical th {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu[align=\"center\"] {\n" +
                "        width: auto !important;\n" +
                "      }\n" +
                "      table.button.small-expand {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.button.small-expanded {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.button.small-expand table {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      table.button.small-expanded table {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      table.button.small-expand table a {\n" +
                "        text-align: center !important;\n" +
                "        width: 100% !important;\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.button.small-expanded table a {\n" +
                "        text-align: center !important;\n" +
                "        width: 100% !important;\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.button.small-expand center {\n" +
                "        min-width: 0;\n" +
                "      }\n" +
                "      table.button.small-expanded center {\n" +
                "        min-width: 0;\n" +
                "      }\n" +
                "      table.body .container {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (min-width: 732px) {\n" +
                "      table.body table.milkyway-email-card {\n" +
                "        width: 525px !important;\n" +
                "      }\n" +
                "      table.body table.emailer-footer {\n" +
                "        width: 525px !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 731px) {\n" +
                "      table.body table.milkyway-email-card {\n" +
                "        width: 320px !important;\n" +
                "      }\n" +
                "      table.body table.emailer-footer {\n" +
                "        width: 320px !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 320px) {\n" +
                "      table.body table.milkyway-email-card {\n" +
                "        width: 100% !important;\n" +
                "        border-radius: 0;\n" +
                "        box-sizing: none;\n" +
                "      }\n" +
                "      table.body table.emailer-footer {\n" +
                "        width: 100% !important;\n" +
                "        border-radius: 0;\n" +
                "        box-sizing: none;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 280px) {\n" +
                "      table.body table.milkyway-email-card .milkyway-content {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (min-width: 596px) {\n" +
                "      .milkyway-header {\n" +
                "        width: 11%;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (max-width: 596px) {\n" +
                "      .milkyway-header {\n" +
                "        width: 50%;\n" +
                "      }\n" +
                "      .emailer-footer .emailer-border-bottom {\n" +
                "        border-bottom: 0.5px solid #E2E5E7;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile {\n" +
                "        margin-top: 24px;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile .email-tag-line {\n" +
                "        width: 80%;\n" +
                "        position: relative;\n" +
                "        left: 10%;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile .universe-address {\n" +
                "        margin-bottom: 10px !important;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile .email-tag-line {\n" +
                "        margin-bottom: 10px !important;\n" +
                "      }\n" +
                "      .have-questions-text {\n" +
                "        width: 70%;\n" +
                "      }\n" +
                "      .hide-on-small {\n" +
                "        display: none;\n" +
                "      }\n" +
                "      .product-card-stacked-row .thumbnail-image {\n" +
                "        max-width: 32% !important;\n" +
                "      }\n" +
                "      .product-card-stacked-row .thumbnail-content p {\n" +
                "        width: 64%;\n" +
                "      }\n" +
                "      .welcome-subcontent {\n" +
                "        text-align: left;\n" +
                "        margin: 20px 0 10px;\n" +
                "      }\n" +
                "      .milkyway-title {\n" +
                "        padding: 16px;\n" +
                "      }\n" +
                "      .meta-data {\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "      .label {\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "      .welcome-email .wavey-background-subcontent {\n" +
                "        width: calc(100% - 32px);\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (min-width: 597px) {\n" +
                "      .emailer-footer .show-on-mobile {\n" +
                "        display: none;\n" +
                "      }\n" +
                "      .emailer-footer .emailer-border-bottom {\n" +
                "        border-bottom: none;\n" +
                "      }\n" +
                "      .have-questions-text {\n" +
                "        border-bottom: none;\n" +
                "      }\n" +
                "      .hide-on-large {\n" +
                "        display: none;\n" +
                "      }\n" +
                "      .milkyway-title {\n" +
                "        padding: 55px 55px 16px;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 290px) {\n" +
                "      table.container.your-tickets .tickets-container {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "    }\n" +
                "  </style>\n" +
                "  <table class=\"body\" data-made-with-foundation=\"\" style=\"background: #FAFAFA; border-collapse: collapse; border-spacing: 0; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; height: 100%; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\"\n" +
                "    bgcolor=\"#FAFAFA\">\n" +
                "    <tbody>\n" +
                "      <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "        <td class=\"center\" align=\"center\" valign=\"top\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\">\n" +
                "          <center style=\"min-width: 580px; width: 100%\">\n" +
                "            <table class=\" spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"20px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 20px; font-weight: normal; hyphens: auto; line-height: 20px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table class=\"header-spacer spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; line-height: 60px; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"16px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 16px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table class=\"header-spacer-bottom spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; line-height: 30px; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"16px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 16px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "\n" +
                "            <table class=\"milkyway-email-card container float-center\" align=\"center\" style=\"background: #FFFFFF; border-collapse: collapse; border-radius: 6px; border-spacing: 0; box-shadow: 0 1px 8px 0 rgba(28,35,43,0.15); float: none; margin: 0 auto; overflow: hidden; padding: 0; text-align: center; vertical-align: top; width: 580px\"\n" +
                "              bgcolor=\"#FFFFFF\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">\n" +
                "\n" +
                "                    <table class=\"milkyway-content confirmation-instructions container\" align=\"center\" style=\"background: #FFFFFF; border-collapse: collapse; border-spacing: 0; hyphens: none; margin: auto; max-width: 100%; padding: 0; text-align: inherit; vertical-align: top; width: 280px !important\"\n" +
                "                      bgcolor=\"#FFFFFF\">\n" +
                "                      <tbody>\n" +
                "                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                          <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                            align=\"left\" valign=\"top\">\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"30px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 30px; font-weight: normal; hyphens: auto; line-height: 30px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\" small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <center style=\"min-width: 0; width: 100%\">\n" +
                "                                              <img width=\"250\" src=\" data:image/png;base64,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\"\n" +
                "                                                align=\"center\" class=\" float-center float-center\" style=\"-ms-interpolation-mode: bicubic; clear: both; display: block; float: none; margin: 0 auto; max-width: 100%; outline: none; text-align: center; text-decoration: none; width: auto\">\n" +
                "                                            </center>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"30px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 30px; font-weight: normal; hyphens: auto; line-height: 30px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"header-padding small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <h1 class=\"welcome-header\" style=\"color: inherit; font-family: Helvetica, Arial, sans-serif; font-size: 24px; font-weight: 600; hyphens: none; line-height: 30px; margin: 0 0 24px; padding: 0; text-align: left; width: 100%; word-wrap: normal\" align=\"left\">\n" +
                "                                              You're ready to go!\n" +
                "                                            </h1>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"body-content small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <h2 class=\"welcome-subcontent\" style=\"color: #6F7881; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300; line-height: 22px; margin: 0; padding: 0; text-align: left; width: 100%; word-wrap: normal\" align=\"left\">\n" +
                "                                              Hey "+username+",\n" +
                "                                            </h2>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"body-content-end small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <h2 class=\"welcome-subcontent\" style=\"color: #6F7881; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300; line-height: 22px; margin: 0; padding: 0; text-align: left; width: 100%; word-wrap: normal\" align=\"left\">\n" +
                "                                              We've finished setting up your ImageSeller account. Just confirm your email to get started!\n" +
                "                                            </h2>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"30px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 30px; font-weight: normal; hyphens: auto; line-height: 30px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\"milkyway-content row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; hyphens: none; margin: auto; max-width: 100%; padding: 0; position: relative; text-align: left; vertical-align: top; width: 280px !important\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"milkyway-padding small-12 large-12 columns first last\" valign=\"middle\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\"\n" +
                "                                    align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <table class=\"cta-text primary radius expanded button\" style=\"border-collapse: collapse; border-spacing: 0; font-size: 14px; font-weight: 400; line-height: 0; margin: 0 0 16px; padding: 0; text-align: left; vertical-align: top; width: 100% !important\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                                  <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                                    align=\"left\" valign=\"top\">\n" +
                "                                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                                      <tbody>\n" +
                "                                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                                          <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; background: #4E78F1; border: 2px none #4e78f1; border-collapse: collapse !important; border-radius: 6px; color: #FFFFFF; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                                            align=\"left\" bgcolor=\"#4E78F1\" valign=\"top\">\n" +
                "                                                            <a href=\""+link+"\" style=\"border: 0 solid #4e78f1; border-radius: 6px; color: #FFFFFF; display: inline-block; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 1.3; margin: 0; padding: 13px 0; text-align: center; text-decoration: none; width: 100%\"\n" +
                "                                                              target=\"_blank\">\n" +
                "                                                              <p class=\"text-center\" style=\"color: white; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300; letter-spacing: 1px; line-height: 1.3; margin: 0; padding: 0; text-align: center\" align=\"center\">\n" +
                "                                                                Confirm email\n" +
                "                                                              </p>\n" +
                "                                                            </a>\n" +
                "                                                          </td>\n" +
                "                                                        </tr>\n" +
                "                                                      </tbody>\n" +
                "                                                    </table>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"10px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 10px; font-weight: normal; hyphens: auto; line-height: 10px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                      </tbody>\n" +
                "                    </table>\n" +
                "\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table class=\" spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"20px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 20px; font-weight: normal; hyphens: auto; line-height: 20px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "          </center>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "</body>";
    }


    public static String getResetMessage(String username, String link){
        return "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=US-ASCII\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"-moz-box-sizing: border-box; -ms-text-size-adjust: 100%; -webkit-box-sizing: border-box; -webkit-text-size-adjust: 100%; box-sizing: border-box; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 22px; margin: 0; min-width: 100%; padding: 0; text-align: left; width: 100% !important\">\n" +
                "  <style type=\"text/css\">\n" +
                "    body {\n" +
                "      width: 100% !important;\n" +
                "      min-width: 100%;\n" +
                "      -webkit-text-size-adjust: 100%;\n" +
                "      -ms-text-size-adjust: 100%;\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      -moz-box-sizing: border-box;\n" +
                "      -webkit-box-sizing: border-box;\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "\n" +
                "    .ExternalClass {\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    .ExternalClass {\n" +
                "      line-height: 100%;\n" +
                "    }\n" +
                "\n" +
                "    #backgroundTable {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      width: 100% !important;\n" +
                "      line-height: 100% !important;\n" +
                "    }\n" +
                "\n" +
                "    img {\n" +
                "      outline: none;\n" +
                "      text-decoration: none;\n" +
                "      -ms-interpolation-mode: bicubic;\n" +
                "      width: auto;\n" +
                "      max-width: 100%;\n" +
                "      clear: both;\n" +
                "      display: block;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      color: #1C232B;\n" +
                "      font-family: Helvetica, Arial, sans-serif;\n" +
                "      font-weight: normal;\n" +
                "      padding: 0;\n" +
                "      margin: 0;\n" +
                "      text-align: left;\n" +
                "      line-height: 1.3;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      font-size: 16px;\n" +
                "      line-height: 1.3;\n" +
                "    }\n" +
                "\n" +
                "    a:hover {\n" +
                "      color: #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    a:active {\n" +
                "      color: #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h1 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h2 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h3 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h4 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h5 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    h6 a:visited {\n" +
                "      color: #4E78F1;\n" +
                "    }\n" +
                "\n" +
                "    table.button:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.tiny:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.tiny:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.tiny table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.small:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.small:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.small table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.large:hover table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.large:active table tr td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.large table tr td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:hover table td {\n" +
                "      background: #1f54ed;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:visited table td {\n" +
                "      background: #1f54ed;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:active table td {\n" +
                "      background: #1f54ed;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button:hover table a {\n" +
                "      border: 0 solid #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    table.button:visited table a {\n" +
                "      border: 0 solid #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    table.button:active table a {\n" +
                "      border: 0 solid #1f54ed;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:hover table td {\n" +
                "      background: #fefefe;\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:hover table a {\n" +
                "      border: 0 solid #fefefe;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:hover table td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary:active table td a {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.secondary table td a:visited {\n" +
                "      color: #FFFFFF;\n" +
                "    }\n" +
                "\n" +
                "    table.button.success:hover table td {\n" +
                "      background: #009482;\n" +
                "    }\n" +
                "\n" +
                "    table.button.success:hover table a {\n" +
                "      border: 0 solid #009482;\n" +
                "    }\n" +
                "\n" +
                "    table.button.alert:hover table td {\n" +
                "      background: #ff6131;\n" +
                "    }\n" +
                "\n" +
                "    table.button.alert:hover table a {\n" +
                "      border: 0 solid #ff6131;\n" +
                "    }\n" +
                "\n" +
                "    table.button.warning:hover table td {\n" +
                "      background: #fcae1a;\n" +
                "    }\n" +
                "\n" +
                "    table.button.warning:hover table a {\n" +
                "      border: 0px solid #fcae1a;\n" +
                "    }\n" +
                "\n" +
                "    .thumbnail:hover {\n" +
                "      box-shadow: 0 0 6px 1px rgba(78, 120, 241, 0.5);\n" +
                "    }\n" +
                "\n" +
                "    .thumbnail:focus {\n" +
                "      box-shadow: 0 0 6px 1px rgba(78, 120, 241, 0.5);\n" +
                "    }\n" +
                "\n" +
                "    body.outlook p {\n" +
                "      display: inline !important;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      font-weight: normal;\n" +
                "      font-size: 16px;\n" +
                "      line-height: 22px;\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 596px) {\n" +
                "      .small-float-center {\n" +
                "        margin: 0 auto !important;\n" +
                "        float: none !important;\n" +
                "        text-align: center !important;\n" +
                "      }\n" +
                "      .small-text-center {\n" +
                "        text-align: center !important;\n" +
                "      }\n" +
                "      .small-text-left {\n" +
                "        text-align: left !important;\n" +
                "      }\n" +
                "      .small-text-right {\n" +
                "        text-align: right !important;\n" +
                "      }\n" +
                "      .hide-for-large {\n" +
                "        display: block !important;\n" +
                "        width: auto !important;\n" +
                "        overflow: visible !important;\n" +
                "        max-height: none !important;\n" +
                "        font-size: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "      }\n" +
                "      table.body table.container .hide-for-large {\n" +
                "        display: table !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body table.container .row.hide-for-large {\n" +
                "        display: table !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body table.container .callout-inner.hide-for-large {\n" +
                "        display: table-cell !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body table.container .show-for-large {\n" +
                "        display: none !important;\n" +
                "        width: 0;\n" +
                "        mso-hide: all;\n" +
                "        overflow: hidden;\n" +
                "      }\n" +
                "      table.body img {\n" +
                "        width: auto;\n" +
                "        height: auto;\n" +
                "      }\n" +
                "      table.body center {\n" +
                "        min-width: 0 !important;\n" +
                "      }\n" +
                "      table.body .container {\n" +
                "        width: 95% !important;\n" +
                "      }\n" +
                "      table.body .columns {\n" +
                "        height: auto !important;\n" +
                "        -moz-box-sizing: border-box;\n" +
                "        -webkit-box-sizing: border-box;\n" +
                "        box-sizing: border-box;\n" +
                "        padding-left: 16px !important;\n" +
                "        padding-right: 16px !important;\n" +
                "      }\n" +
                "      table.body .column {\n" +
                "        height: auto !important;\n" +
                "        -moz-box-sizing: border-box;\n" +
                "        -webkit-box-sizing: border-box;\n" +
                "        box-sizing: border-box;\n" +
                "        padding-left: 16px !important;\n" +
                "        padding-right: 16px !important;\n" +
                "      }\n" +
                "      table.body .columns .column {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .columns .columns {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .column .column {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .column .columns {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .collapse .columns {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.body .collapse .column {\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      td.small-1 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 8.333333% !important;\n" +
                "      }\n" +
                "      th.small-1 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 8.333333% !important;\n" +
                "      }\n" +
                "      td.small-2 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 16.666666% !important;\n" +
                "      }\n" +
                "      th.small-2 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 16.666666% !important;\n" +
                "      }\n" +
                "      td.small-3 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 25% !important;\n" +
                "      }\n" +
                "      th.small-3 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 25% !important;\n" +
                "      }\n" +
                "      td.small-4 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 33.333333% !important;\n" +
                "      }\n" +
                "      th.small-4 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 33.333333% !important;\n" +
                "      }\n" +
                "      td.small-5 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 41.666666% !important;\n" +
                "      }\n" +
                "      th.small-5 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 41.666666% !important;\n" +
                "      }\n" +
                "      td.small-6 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 50% !important;\n" +
                "      }\n" +
                "      th.small-6 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 50% !important;\n" +
                "      }\n" +
                "      td.small-7 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 58.333333% !important;\n" +
                "      }\n" +
                "      th.small-7 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 58.333333% !important;\n" +
                "      }\n" +
                "      td.small-8 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 66.666666% !important;\n" +
                "      }\n" +
                "      th.small-8 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 66.666666% !important;\n" +
                "      }\n" +
                "      td.small-9 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 75% !important;\n" +
                "      }\n" +
                "      th.small-9 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 75% !important;\n" +
                "      }\n" +
                "      td.small-10 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 83.333333% !important;\n" +
                "      }\n" +
                "      th.small-10 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 83.333333% !important;\n" +
                "      }\n" +
                "      td.small-11 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 91.666666% !important;\n" +
                "      }\n" +
                "      th.small-11 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 91.666666% !important;\n" +
                "      }\n" +
                "      td.small-12 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      th.small-12 {\n" +
                "        display: inline-block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .columns td.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .column td.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .columns th.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .column th.small-12 {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-1 {\n" +
                "        margin-left: 8.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-1 {\n" +
                "        margin-left: 8.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-2 {\n" +
                "        margin-left: 16.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-2 {\n" +
                "        margin-left: 16.666666% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-3 {\n" +
                "        margin-left: 25% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-3 {\n" +
                "        margin-left: 25% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-4 {\n" +
                "        margin-left: 33.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-4 {\n" +
                "        margin-left: 33.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-5 {\n" +
                "        margin-left: 41.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-5 {\n" +
                "        margin-left: 41.666666% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-6 {\n" +
                "        margin-left: 50% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-6 {\n" +
                "        margin-left: 50% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-7 {\n" +
                "        margin-left: 58.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-7 {\n" +
                "        margin-left: 58.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-8 {\n" +
                "        margin-left: 66.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-8 {\n" +
                "        margin-left: 66.666666% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-9 {\n" +
                "        margin-left: 75% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-9 {\n" +
                "        margin-left: 75% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-10 {\n" +
                "        margin-left: 83.333333% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-10 {\n" +
                "        margin-left: 83.333333% !important;\n" +
                "      }\n" +
                "      table.body td.small-offset-11 {\n" +
                "        margin-left: 91.666666% !important;\n" +
                "      }\n" +
                "      table.body th.small-offset-11 {\n" +
                "        margin-left: 91.666666% !important;\n" +
                "      }\n" +
                "      table.body table.columns td.expander {\n" +
                "        display: none !important;\n" +
                "      }\n" +
                "      table.body table.columns th.expander {\n" +
                "        display: none !important;\n" +
                "      }\n" +
                "      table.body .right-text-pad {\n" +
                "        padding-left: 10px !important;\n" +
                "      }\n" +
                "      table.body .text-pad-right {\n" +
                "        padding-left: 10px !important;\n" +
                "      }\n" +
                "      table.body .left-text-pad {\n" +
                "        padding-right: 10px !important;\n" +
                "      }\n" +
                "      table.body .text-pad-left {\n" +
                "        padding-right: 10px !important;\n" +
                "      }\n" +
                "      table.menu {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.menu td {\n" +
                "        width: auto !important;\n" +
                "        display: inline-block !important;\n" +
                "      }\n" +
                "      table.menu th {\n" +
                "        width: auto !important;\n" +
                "        display: inline-block !important;\n" +
                "      }\n" +
                "      table.menu.vertical td {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu.vertical th {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu.small-vertical td {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu.small-vertical th {\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      table.menu[align=\"center\"] {\n" +
                "        width: auto !important;\n" +
                "      }\n" +
                "      table.button.small-expand {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.button.small-expanded {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table.button.small-expand table {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      table.button.small-expanded table {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      table.button.small-expand table a {\n" +
                "        text-align: center !important;\n" +
                "        width: 100% !important;\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.button.small-expanded table a {\n" +
                "        text-align: center !important;\n" +
                "        width: 100% !important;\n" +
                "        padding-left: 0 !important;\n" +
                "        padding-right: 0 !important;\n" +
                "      }\n" +
                "      table.button.small-expand center {\n" +
                "        min-width: 0;\n" +
                "      }\n" +
                "      table.button.small-expanded center {\n" +
                "        min-width: 0;\n" +
                "      }\n" +
                "      table.body .container {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (min-width: 732px) {\n" +
                "      table.body table.milkyway-email-card {\n" +
                "        width: 525px !important;\n" +
                "      }\n" +
                "      table.body table.emailer-footer {\n" +
                "        width: 525px !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 731px) {\n" +
                "      table.body table.milkyway-email-card {\n" +
                "        width: 320px !important;\n" +
                "      }\n" +
                "      table.body table.emailer-footer {\n" +
                "        width: 320px !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 320px) {\n" +
                "      table.body table.milkyway-email-card {\n" +
                "        width: 100% !important;\n" +
                "        border-radius: 0;\n" +
                "        box-sizing: none;\n" +
                "      }\n" +
                "      table.body table.emailer-footer {\n" +
                "        width: 100% !important;\n" +
                "        border-radius: 0;\n" +
                "        box-sizing: none;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 280px) {\n" +
                "      table.body table.milkyway-email-card .milkyway-content {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (min-width: 596px) {\n" +
                "      .milkyway-header {\n" +
                "        width: 11%;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (max-width: 596px) {\n" +
                "      .milkyway-header {\n" +
                "        width: 50%;\n" +
                "      }\n" +
                "      .emailer-footer .emailer-border-bottom {\n" +
                "        border-bottom: 0.5px solid #E2E5E7;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile {\n" +
                "        margin-top: 24px;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile .email-tag-line {\n" +
                "        width: 80%;\n" +
                "        position: relative;\n" +
                "        left: 10%;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile .universe-address {\n" +
                "        margin-bottom: 10px !important;\n" +
                "      }\n" +
                "      .emailer-footer .make-you-smile .email-tag-line {\n" +
                "        margin-bottom: 10px !important;\n" +
                "      }\n" +
                "      .have-questions-text {\n" +
                "        width: 70%;\n" +
                "      }\n" +
                "      .hide-on-small {\n" +
                "        display: none;\n" +
                "      }\n" +
                "      .product-card-stacked-row .thumbnail-image {\n" +
                "        max-width: 32% !important;\n" +
                "      }\n" +
                "      .product-card-stacked-row .thumbnail-content p {\n" +
                "        width: 64%;\n" +
                "      }\n" +
                "      .welcome-subcontent {\n" +
                "        text-align: left;\n" +
                "        margin: 20px 0 10px;\n" +
                "      }\n" +
                "      .milkyway-title {\n" +
                "        padding: 16px;\n" +
                "      }\n" +
                "      .meta-data {\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "      .label {\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "      .welcome-email .wavey-background-subcontent {\n" +
                "        width: calc(100% - 32px);\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media (min-width: 597px) {\n" +
                "      .emailer-footer .show-on-mobile {\n" +
                "        display: none;\n" +
                "      }\n" +
                "      .emailer-footer .emailer-border-bottom {\n" +
                "        border-bottom: none;\n" +
                "      }\n" +
                "      .have-questions-text {\n" +
                "        border-bottom: none;\n" +
                "      }\n" +
                "      .hide-on-large {\n" +
                "        display: none;\n" +
                "      }\n" +
                "      .milkyway-title {\n" +
                "        padding: 55px 55px 16px;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 290px) {\n" +
                "      table.container.your-tickets .tickets-container {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "    }\n" +
                "  </style>\n" +
                "  <table class=\"body\" data-made-with-foundation=\"\" style=\"background: #FAFAFA; border-collapse: collapse; border-spacing: 0; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; height: 100%; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\"\n" +
                "    bgcolor=\"#FAFAFA\">\n" +
                "    <tbody>\n" +
                "      <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "        <td class=\"center\" align=\"center\" valign=\"top\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\">\n" +
                "          <center style=\"min-width: 580px; width: 100%\">\n" +
                "            <table class=\" spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"20px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 20px; font-weight: normal; hyphens: auto; line-height: 20px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table class=\"header-spacer spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; line-height: 60px; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"16px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 16px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table class=\"header-spacer-bottom spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; line-height: 30px; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"16px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 16px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "\n" +
                "            <table class=\"milkyway-email-card container float-center\" align=\"center\" style=\"background: #FFFFFF; border-collapse: collapse; border-radius: 6px; border-spacing: 0; box-shadow: 0 1px 8px 0 rgba(28,35,43,0.15); float: none; margin: 0 auto; overflow: hidden; padding: 0; text-align: center; vertical-align: top; width: 580px\"\n" +
                "              bgcolor=\"#FFFFFF\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">\n" +
                "\n" +
                "                    <table class=\"milkyway-content confirmation-instructions container\" align=\"center\" style=\"background: #FFFFFF; border-collapse: collapse; border-spacing: 0; hyphens: none; margin: auto; max-width: 100%; padding: 0; text-align: inherit; vertical-align: top; width: 280px !important\"\n" +
                "                      bgcolor=\"#FFFFFF\">\n" +
                "                      <tbody>\n" +
                "                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                          <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                            align=\"left\" valign=\"top\">\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"30px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 30px; font-weight: normal; hyphens: auto; line-height: 30px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\" small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <center style=\"min-width: 0; width: 100%\">\n" +
                "                                              <img width=\"250\" src=\" data:image/png;base64,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\"\n" +
                "                                                align=\"center\" class=\" float-center float-center\" style=\"-ms-interpolation-mode: bicubic; clear: both; display: block; float: none; margin: 0 auto; max-width: 100%; outline: none; text-align: center; text-decoration: none; width: auto\">\n" +
                "                                            </center>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"30px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 30px; font-weight: normal; hyphens: auto; line-height: 30px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"header-padding small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <h1 class=\"welcome-header\" style=\"color: inherit; font-family: Helvetica, Arial, sans-serif; font-size: 24px; font-weight: 600; hyphens: none; line-height: 30px; margin: 0 0 24px; padding: 0; text-align: left; width: 100%; word-wrap: normal\" align=\"left\">\n" +
                "                                              You're ready to go!\n" +
                "                                            </h1>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"body-content small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <h2 class=\"welcome-subcontent\" style=\"color: #6F7881; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300; line-height: 22px; margin: 0; padding: 0; text-align: left; width: 100%; word-wrap: normal\" align=\"left\">\n" +
                "                                              Hey "+username+",\n" +
                "                                            </h2>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; padding: 0; position: relative; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"body-content-end small-12 large-12 columns first last\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\" align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <h2 class=\"welcome-subcontent\" style=\"color: #6F7881; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300; line-height: 22px; margin: 0; padding: 0; text-align: left; width: 100%; word-wrap: normal\" align=\"left\">\n" +
                "                                              You have requested password reset of your ImageSeller account. Just hit the reset button to proceed! If you didn't request this just ignore or delete this mail\n" +
                "                                            </h2>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"30px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 30px; font-weight: normal; hyphens: auto; line-height: 30px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                            <table class=\"milkyway-content row\" style=\"border-collapse: collapse; border-spacing: 0; display: table; hyphens: none; margin: auto; max-width: 100%; padding: 0; position: relative; text-align: left; vertical-align: top; width: 280px !important\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <th class=\"milkyway-padding small-12 large-12 columns first last\" valign=\"middle\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0 auto; padding: 0; text-align: left; width: 564px\"\n" +
                "                                    align=\"left\">\n" +
                "                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                      <tbody>\n" +
                "                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                          <th style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left\" align=\"left\">\n" +
                "                                            <table class=\"cta-text primary radius expanded button\" style=\"border-collapse: collapse; border-spacing: 0; font-size: 14px; font-weight: 400; line-height: 0; margin: 0 0 16px; padding: 0; text-align: left; vertical-align: top; width: 100% !important\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                                  <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                                    align=\"left\" valign=\"top\">\n" +
                "                                                    <table style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                                                      <tbody>\n" +
                "                                                        <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                                          <td style=\"-moz-hyphens: auto; -webkit-hyphens: auto; background: #4E78F1; border: 2px none #4e78f1; border-collapse: collapse !important; border-radius: 6px; color: #FFFFFF; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; hyphens: auto; line-height: 1.3; margin: 0; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                                            align=\"left\" bgcolor=\"#4E78F1\" valign=\"top\">\n" +
                "                                                            <a href=\""+link+"\" style=\"border: 0 solid #4e78f1; border-radius: 6px; color: #FFFFFF; display: inline-block; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 1.3; margin: 0; padding: 13px 0; text-align: center; text-decoration: none; width: 100%\"\n" +
                "                                                              target=\"_blank\">\n" +
                "                                                              <p class=\"text-center\" style=\"color: white; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300; letter-spacing: 1px; line-height: 1.3; margin: 0; padding: 0; text-align: center\" align=\"center\">\n" +
                "                                                                Reset Password\n" +
                "                                                              </p>\n" +
                "                                                            </a>\n" +
                "                                                          </td>\n" +
                "                                                        </tr>\n" +
                "                                                      </tbody>\n" +
                "                                                    </table>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </th>\n" +
                "                                          <th class=\"expander\" style=\"color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 16px; font-weight: normal; line-height: 1.3; margin: 0; padding: 0; text-align: left; visibility: hidden; width: 0\" align=\"left\"></th>\n" +
                "                                        </tr>\n" +
                "                                      </tbody>\n" +
                "                                    </table>\n" +
                "                                  </th>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "\n" +
                "                            <table class=\" spacer \" style=\"border-collapse: collapse; border-spacing: 0; padding: 0; text-align: left; vertical-align: top; width: 100%\">\n" +
                "                              <tbody>\n" +
                "                                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                                  <td height=\"10px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 10px; font-weight: normal; hyphens: auto; line-height: 10px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                              </tbody>\n" +
                "                            </table>\n" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                      </tbody>\n" +
                "                    </table>\n" +
                "\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "            <table class=\" spacer  float-center\" align=\"center\" style=\"border-collapse: collapse; border-spacing: 0; float: none; margin: 0 auto; padding: 0; text-align: center; vertical-align: top; width: 100%\">\n" +
                "              <tbody>\n" +
                "                <tr style=\"padding: 0; text-align: left; vertical-align: top\" align=\"left\">\n" +
                "                  <td height=\"20px\" style=\"-moz-hyphens: auto; -webkit-hyphens: auto; border-collapse: collapse !important; color: #1C232B; font-family: Helvetica, Arial, sans-serif; font-size: 20px; font-weight: normal; hyphens: auto; line-height: 20px; margin: 0; mso-line-height-rule: exactly; padding: 0; text-align: left; vertical-align: top; word-wrap: break-word\"\n" +
                "                    align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "              </tbody>\n" +
                "            </table>\n" +
                "          </center>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "</body>";
    }
}
