<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
        <head>
            <title>Llista Estudiants</title>
            <!--Bootstrap-->
  			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        	
        	<style>
	        div { margin: 1rem; }
	        body { text-align: center; }
	        </style>
        </head>
        <body>
        	<div>
        		<div>
            		<h2 >Estudiants</h2>
            	</div>
        		<div>
		            <table class='table table-striped table-hover table-dark' style='text-align: center;'>
		                <tr>
		                    <th>Nom</th>
		                    <th>Edat</th>
		                </tr>
		                <xsl:for-each select="studentslist/student">
	                    <tr>
	                        <td><xsl:value-of select="@name"/></td>
	                        <td><xsl:value-of select="@age"/></td>
	                    </tr>
		                </xsl:for-each>
		            </table>
        		</div>
            </div>
			<!--Bootstrap-->
		    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
