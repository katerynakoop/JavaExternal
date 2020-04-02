<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    h2
                    {
                        text-align:center;
                    }

                    th
                    {
                        border: 1px solid black;
                        text-align:left;
                    }

                    td
                    {
                        border: 1px solid black;
                    }

                    table
                    {
                        width:100%;
                        background-color: #f1f1c1;
                        font-size: 14pt;
                        border: 1px solid black;
                        border-collapse: collapse;
                    }
                </style>
                <meta charset="utf-8"/>
                <title>Beer</title>
            </head>

            <body>
                <h2>Beer info</h2>

                <table>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Alcohol</th>
                        <th>Manufacturer</th>
                        <th>Water</th>
                        <th>Grain</th>
                        <th>Hops</th>
                        <th>Yeast</th>
                        <th>Sugar</th>
                        <th>Strength</th>
                        <th>Transparency</th>
                        <th>Filtering</th>
                        <th>Nutritional value</th>
                    </tr>
                    <xsl:for-each select="beers/beer">
                    <tr>
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="type"/></td>
                        <td><xsl:value-of select="alcohol"/></td>
                        <td><xsl:value-of select="manufacturer"/></td>
                        <td><xsl:value-of select="ingredients/water"/></td>
                        <td><xsl:value-of select="ingredients/grain"/></td>
                        <td><xsl:value-of select="ingredients/hops"/></td>
                        <td><xsl:value-of select="ingredients/yeast"/></td>
                        <td><xsl:value-of select="ingredients/sugar"/></td>
                        <td><xsl:value-of select="characteristics/strength"/></td>
                        <td><xsl:value-of select="characteristics/transparency"/></td>
                        <td><xsl:value-of select="characteristics/filtering"/></td>
                        <td><xsl:value-of select="characteristics/nutritional_value"/></td>
                    </tr>
                    </xsl:for-each>
                </table>

                 </body>

        </html>
    </xsl:template>
</xsl:stylesheet>