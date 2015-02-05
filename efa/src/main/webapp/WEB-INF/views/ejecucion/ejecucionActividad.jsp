<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url var="editUrl" value="/uminera/editum/" />
<c:url var="delUrl" value="/uminera/deleteum/" />
<c:url var="admUrl" value="/administrados/" />
<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listEjecActividad.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<span> Ejecución Actividad</span>
		
		<h2>Ejecución de Actividad </h2>
		<h4>Código Actividad: ${act.codactividad}</h4>	
		<h4>EFA: ${efa.nombre}</h4>	
		<h4>Ubigeo: ${act.departamentodes} ${act.provinciades} ${act.distritodes}</h4>	

		<div>
		<%@ include file="ejecucionFileForm.jsp"%>
		</div>

		<div>
			<%@ include file="ejecucionActForm.jsp"%>
		</div>	

	
        

    </jsp:body>
</t:simple>