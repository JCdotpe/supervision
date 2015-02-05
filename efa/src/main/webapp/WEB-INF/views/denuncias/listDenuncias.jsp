<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <!--<div id="bookDialog" style="display: none;">
        </div>
        -->
        <span> Consulta </span>

        <h2>Consulta de Denuncias</h2>

        <div>
            <%@ include file="denunciaSinadaForm.jsp" %>
        </div>
        <br/>
        <br/>

        <table class="table datatable uppertext" id="tblAct">
            <thead>
            <tr>
                <th width="1%"></th>
                <th width="8%">Código SINADA</th>
                <th width="12%">Nombre denunciante</th>
                <th width="8%">Raz&oacute;n social denunciante</th>
                <th width="12%">Nombre denunciado</th>
                <th width="8%">Raz&oacute;n social denunciado</th>
                <th width="8%">Descripci&oacute;n de los hechos</th>
                <th width="8%">Fecha de denuncia</th>
                <th width="3%">Fecha de sistema</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${denuncias}" var="denuncia" varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}"/></td>
                    <td><c:out value="${denuncia.codigoSinada}"/></td>
                    <td><c:out value="${denuncia.denunciante}"/></td>
                    <td><c:out value="${denuncia.razonSocialDenunciante}"/></td>
                    <td><c:out value="${denuncia.denunciado}"/></td>
                    <td><c:out value="${denuncia.razonSocialDenunciado}"/></td>
                    <td><c:out value="${denuncia.descHecho}"/></td>
                    <td><c:out value="${denuncia.fechaDenuncia}"/></td>
                    <td><c:out value="${denuncia.fechaRegistro}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:simple>