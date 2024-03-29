package com.groupeisi.ecommercegraphql.service.impl;

import org.springframework.stereotype.Component;

@Component
public class MailView {
    /**
     * @return html mail
     */

    public String mailView(String name,String code,String link) {
        return String.format(
                "<html >\n" +
                        "\n" +
                        "            <head>\n" +
                        "            </head>\n" +
                        "\n" +
                        "            <body>\n" +
                        "            <div class='is-centered'>\n" +
                        "                <table border='0' cellpadding='0' cellspacing='0' height='100%%%%' width='100%%%%' id='bodyTbl'\n" +
                        "                       style='table-layout: fixed;max-width:100%%%% !important;width: 100%%%% !important;min-width: 100%%%% !important;'>\n" +
                        "                    <tr>\n" +
                        "                        <td align='center' valign='top' id='bodyCell'>\n" +
                        "\n" +
                        "                            <table width='500' id='emailHeader'>\n" +
                        "                                <tr>\n" +
                        "                                    <td align='center' valign='top'>\n" +
                        "\n" +
                        "                                        <table border='0' cellpadding='0' cellspacing='0' width='100%%%%'>\n" +
                        "                                            <tr>\n" +
                        "                                                <td align='center' valign='top'>\n" +
                        "\n" +
                        "                                                    <table border='0' cellpadding='10' cellspacing='0' width='500'\n" +
                        "                                                           class='flexibleContainer'>\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td valign='top' width='500' class='flexibleContainerCell'>\n" +
                        "\n" +
                        "                                                                <table align='left' border='0' cellpadding='0' cellspacing='0'\n" +
                        "                                                                       width='100%%%%'>\n" +
                        "                                                                    <tr>\n" +
                        "                                                                        <td align='left' valign='middle' id='invisibleIntroduction'\n" +
                        "                                                                            class='flexibleContainerBox'\n" +
                        "                                                                            style='display:none;display:none !important;'>\n" +
                        "                                                                            <table border='0' cellpadding='0' cellspacing='0'\n" +
                        "                                                                                   width='100%%%%' style='max-width:100%%%%;'>\n" +
                        "                                                                                <tr>\n" +
                        "                                                                                    <td align='left' class='textContent'>\n" +
                        "                                                                                        <div style='font-family:Helvetica,Arial,sans-serif;font-size:13px;color:#828282;text-align:center;line-height:120%%%%;'>\n" +
                        "                                                                                        </div>\n" +
                        "                                                                                    </td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </table>\n" +
                        "                                                                        </td>\n" +
                        "                                                                    </tr>\n" +
                        "                                                                </table>\n" +
                        "                                                            </td>\n" +
                        "                                                        </tr>\n" +
                        "                                                    </table>\n" +
                        "\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "                            </table>\n" +
                        "\n" +
                        "                            <table bgcolor='#FFFFFF' border='0' cellpadding='0' cellspacing='0' width='500' id='emailBody'>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td align='center' valign='top'>\n" +
                        "                                        <table border='0' cellpadding='0' cellspacing='0' width='100%%%%' style='color:#FFFFFF;'\n" +
                        "                                               bgcolor='#2E7D32'>\n" +
                        "                                            <tr>\n" +
                        "                                                <td align='center' valign='top'>\n" +
                        "                                                    <table border='0' cellpadding='0' cellspacing='0' width='500'\n" +
                        "                                                           class='flexibleContainer'>\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td align='center' valign='top' width='500'\n" +
                        "                                                                class='flexibleContainerCell'>\n" +
                        "                                                                <table border='0' cellpadding='30' cellspacing='0' width='100%%%%'>\n" +
                        "                                                                    <tr>\n" +
                        "                                                                        <td align='center' valign='top' class='textContent'>\n" +
                        "                                                                            <h1 style='color:#FFFFFF;line-height:100%%%%;font-family:Helvetica,Arial,sans-serif;font-size:35px;font-weight:normal;margin-bottom:5px;text-align:center;'>\n" +
                        "                                                                                Naby Market </h1>\n" +
                        "                                                                            <h2 style='text-align:center;font-weight:normal;font-family:Helvetica,Arial,sans-serif;font-size:23px;margin-bottom:10px;color:#c9bc20;line-height:135%%%%;'>\n" +
                        "                                                                                Code d'activation de votre compte</h2>\n" +
                        "                                                                            <div style='text-align:center;font-family:Helvetica,Arial,sans-serif;font-size:15px;margin-bottom:0;color:#FFFFFF;line-height:135%%%%;'>\n" +
                        "                                                                                Terminez votre inscription\n" +
                        "                                                                            </div>\n" +
                        "                                                                        </td>\n" +
                        "                                                                    </tr>\n" +
                        "                                                                </table>\n" +
                        "                                                            </td>\n" +
                        "                                                        </tr>\n" +
                        "                                                    </table>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "                                <tr>\n" +
                        "                                    <td align='center' valign='top'>\n" +
                        "                                        <table border='0' cellpadding='0' cellspacing='0' width='100%%%%'>\n" +
                        "                                            <tr>\n" +
                        "                                                <td align='center' valign='top'>\n" +
                        "                                                    <table border='0' cellpadding='0' cellspacing='0' width='500'\n" +
                        "                                                           class='flexibleContainer'>\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td align='center' valign='top' width='500'\n" +
                        "                                                                class='flexibleContainerCell'>\n" +
                        "                                                                <table border='0' cellpadding='30' cellspacing='0' width='100%%%%'>\n" +
                        "                                                                    <tr>\n" +
                        "                                                                        <td align='center' valign='top'>\n" +
                        "\n" +
                        "                                                                            <table border='0' cellpadding='0' cellspacing='0'\n" +
                        "                                                                                   width='100%%%%'>\n" +
                        "                                                                                <tr>\n" +
                        "                                                                                    <td valign='top' class='textContent'>\n" +
                        "                                                                                        <h3 style='color:#ffff;line-height:125%%%%;font-family:Helvetica,Arial,sans-serif;font-size:20px;font-weight:normal;margin-top:0;margin-bottom:3px;text-align:left;'>\n" +
                        "                                                                                            Bonjour %s,</h3>\n" +
                        "                                                                                        <div style='color:white;text-align:left;font-family:Helvetica,Arial,sans-serif;font-size:15px;margin-bottom:0;margin-top:3px;color:#5F5F5F;line-height:135%%%%;'>\n" +
                        "                                                                                            <br/>  Votre code d'activation est : <b>%s</b>\n" +
                        "                                                                                        </div>\n" +
                        "                                                                                    </td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </table>\n" +
                        "\n" +
                        "                                                                        </td>\n" +
                        "                                                                    </tr>\n" +
                        "                                                                </table>\n" +
                        "                                                            </td>\n" +
                        "                                                        </tr>\n" +
                        "                                                    </table>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                                <tr>\n" +
                        "                                    <td align='center' valign='top'>\n" +
                        "                                        <table border='0' cellpadding='0' cellspacing='0' width='100%%%%' bgcolor='#F8F8F8'>\n" +
                        "                                            <tr>\n" +
                        "                                                <td align='center' valign='top'>\n" +
                        "                                                    <table border='0' cellpadding='0' cellspacing='0' width='500'\n" +
                        "                                                           class='flexibleContainer'>\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td align='center' valign='top' width='500'\n" +
                        "                                                                class='flexibleContainerCell'>\n" +
                        "                                                                <table border='0' cellpadding='30' cellspacing='0' width='100%%%%'>\n" +
                        "                                                                    <tr>\n" +
                        "                                                                        <td align='center' valign='top'>\n" +
                        "                                                                            <table border='0' cellpadding='0' cellspacing='0'\n" +
                        "                                                                                   width='50%%%%' class='emailButton'\n" +
                        "                                                                                   style='background-color: #2E7D32;'>\n" +
                        "                                                                                <tr>\n" +
                        "                                                                                    <td align='center' valign='middle'\n" +
                        "                                                                                        class='buttonContent'\n" +
                        "                                                                                        style='padding-top:15px;padding-bottom:15px;padding-right:15px;padding-left:15px;'>\n" +
                        "                                                                                        <a style='color:#FFFFFF;text-decoration:none;font-family:Helvetica,Arial,sans-serif;font-size:20px;line-height:135%%%%;'\n" +
                        "                                                                                           href='%s' target='_blank'>S'inscrire</a>\n" +
                        "                                                                                    </td>\n" +
                        "                                                                                </tr>\n" +
                        "                                                                            </table>\n" +
                        "\n" +
                        "                                                                        </td>\n" +
                        "                                                                    </tr>\n" +
                        "                                                                </table>\n" +
                        "                                                            </td>\n" +
                        "                                                        </tr>\n" +
                        "                                                    </table>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "\n" +
                        "                            </table>\n" +
                        "\n" +
                        "                            <!-- footer -->\n" +
                        "                            <table bgcolor='#E1E1E1' border='0' cellpadding='0' cellspacing='0' width='500' id='emailFooter'>\n" +
                        "                                <tr>\n" +
                        "                                    <td align='center' valign='top'>\n" +
                        "                                        <table border='0' cellpadding='0' cellspacing='0' width='100%%%%'>\n" +
                        "                                            <tr>\n" +
                        "                                                <td align='center' valign='top'>\n" +
                        "                                                    <table border='0' cellpadding='0' cellspacing='0' width='500'\n" +
                        "                                                           class='flexibleContainer'>\n" +
                        "                                                        <tr>\n" +
                        "                                                            <td align='center' valign='top' width='500'\n" +
                        "                                                                class='flexibleContainerCell'>\n" +
                        "                                                                <table border='0' cellpadding='30' cellspacing='0' width='100%%%%'>\n" +
                        "                                                                    <tr>\n" +
                        "                                                                        <td valign='top' bgcolor='#E1E1E1'>\n" +
                        "\n" +
                        "                                                                            <div style='font-family:Helvetica,Arial,sans-serif;font-size:13px;color:#828282;text-align:center;line-height:120%%%%;'>\n" +
                        "                                                                                <div>Copyright &#169; 2024. All rights reserved Mo elite.\n" +
                        "                                                                                </div>\n" +
                        "                                                                                <div>If you don't want to receive these emails from\n" +
                        "                                                                                    us in the future, please <a\n" +
                        "                                                                                            href=''\n" +
                        "                                                                                            target='_blank'\n" +
                        "                                                                                            style='text-decoration:none;color:#828282;'><span\n" +
                        "                                                                                            style='color:#828282;'>unsubscribe</span></a>\n" +
                        "                                                                                </div>\n" +
                        "                                                                            </div>\n" +
                        "\n" +
                        "                                                                        </td>\n" +
                        "                                                                    </tr>\n" +
                        "                                                                </table>\n" +
                        "                                                            </td>\n" +
                        "                                                        </tr>\n" +
                        "                                                    </table>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "                            </table>\n" +
                        "                            <!-- // end of footer -->\n" +
                        "\n" +
                        "                        </td>\n" +
                        "                    </tr>\n" +
                        "                </table>\n" +
                        "            </div>\n" +
                        "            </body>\n" +
                        "\n" +
                        "            </html>",name,code,link);

    }


}
