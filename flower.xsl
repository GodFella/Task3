<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : flowers.xsl
    Created on : 22 грудня 2012, 14:59
    Author     : Gleb
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>flower.xsl</title>
            </head>
            <body>
                <h1>Orangerie</h1>
                <table border="1" style="color:blue">
                    <thead>
                        <tr>
                            <td rowspan="2">Id</td>
                            <td rowspan="2">Name</td>
                            <td rowspan="2">Soil</td>
                            <td rowspan="2">Origin</td>
                            <td colspan="3">Visual parameters</td>
                            <td colspan="3">Growing tips</td>
                            <td rowspan="2">Multiplying</td>    
                        </tr>
                        <tr>
                            <td>Stem colour</td>
                            <td>Leaves colour</td>
                            <td>Average size</td>
                            <td>Temperature</td>
                            <td>Light</td>
                            <td>Watering</td>
                        </tr>
                    </thead>
                    <tbody>
                    <xsl:for-each select="orangerie/flower">
                        <tr>
                            <td>
                                <xsl:value-of select="@id"/>
                            </td>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="soil"/>
                            </td>
                            <td>
                                <xsl:value-of select="origin"/>
                            </td>
                            <td>
                                <xsl:value-of select="visual_parameters/stem_colour"/>
                            </td>
                            <td>
                                <xsl:value-of select="visual_parameters/leaves_colour"/>
                            </td>
                            <td>
                                <xsl:value-of select="visual_parameters/average_size"/>
                                (
                                <xsl:value-of select="visual_parameters/average_size/@unit"/>
                                )
                            </td>
                            <td>
                                <xsl:value-of select="growing_tips/temperature"/>
                                (
                                <xsl:value-of select="growing_tips/temperature/@grade"/>
                                )
                            </td>
                            <td>
                                <xsl:value-of select="growing_tips/light"/>
                            </td>
                            <td>
                                <xsl:value-of select="growing_tips/watering"/>
                                (
                                <xsl:value-of select="growing_tips/watering/@unit"/>
                                )
                            </td>
                            <td>
                                <xsl:value-of select="multiplying"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                    </tbody>
                </table>
                    
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>