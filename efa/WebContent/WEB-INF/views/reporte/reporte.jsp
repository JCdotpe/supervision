<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
            src='<c:url value="/web-resources/js/js-for-listActSupervision.js"/>'></script>
    </jsp:attribute>

    <jsp:body>
        <span> Reportes </span>

        <h2>Reportes</h2>

        <div>
            <%@include file="../reporte/reporteForm.jsp" %>
        </div>
        <br/>
        <br/>

        <table class="table datatable uppertext" id="tblAct">
            <thead>
            <tr>
                <th width="1%"></th>
                <th width="8%">Nro Actividad</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Estado de la actividad</th>
                <th>Descripci&oacute;n de la actividad</th>
                <th>Nivel de Gobierno</th>
                <th>Nombre EFA</th>
                <th>Tipo de Supervisi&oacute;n</th>
                <th>Tema de Supervisi&oacute;n</th>
                <th>Supervisor Responsable</th>
                <th>Equipo Supervisores</th>
                <th>Requiri&oacute; Analítica</th>
                <th>Departamento</th>
                <th>Provincia</th>
                <th>Distrito</th>
                <th>Componente</th>
                <th>Subcomponente</th>
                <th>Indicador</th>
                <th>Observaci&oacute;n</th>
                <th>Requiere supervisi&oacute;n especial</th>
                <th>Presenta hallazgos cr&iacute;ticos</th>
                <th>Tipo & n&uacute;mero de documento</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reporteActividad}" var="reporte" varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}"/></td>
                    <td><c:out value="${reporte.numero}"/></td>
                    <td><c:out value="${reporte.fechaInicio}"/></td>
                    <td><c:out value="${reporte.fechaFin}"/></td>
                    <td><c:out value="${reporte.estado}"/></td>
                    <td><c:out value="${reporte.descripcion}"/></td>
                    <td><c:out value="${reporte.nivelGobierno}"/></td>
                    <td><c:out value="${reporte.efa}"/></td>
                    <td><c:out value="${reporte.tipoSupervision}"/></td>
                    <td><c:out value="${reporte.temaSupervision}"/></td>
                    <td><c:out value="${reporte.supervisor}"/></td>
                    <td><c:out value="${reporte.supervisores}"/></td>
                    <td><c:out value="${reporte.analitica}"/></td>
                    <td><c:out value="${reporte.departamento}"/></td>
                    <td><c:out value="${reporte.provincia}"/></td>
                    <td><c:out value="${reporte.distrito}"/></td>
                    <td><c:out value="${reporte.componente}"/></td>
                    <td><c:out value="${reporte.subComponente}"/></td>
                    <td><c:out value="${reporte.indicador}"/></td>
                    <td><c:out value="${reporte.observacion}"/></td>
                    <td><c:out value="${reporte.supervisionEspecial}"/></td>
                    <td><c:out value="${reporte.hallazgosCriticos}"/></td>
                    <td><c:out value="${reporte.documento}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:simple>