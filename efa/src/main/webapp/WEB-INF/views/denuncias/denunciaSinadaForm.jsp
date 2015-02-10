<%--
  Created by IntelliJ IDEA.
  User: hgonzales
  Date: 03/12/2014
  Time: 03:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="actionUrl" value="${pageContext.request.contextPath}/sinada"/>

<form:form modelAttribute="denunciaForm" cssClass="form-horizontal upperx" acceptCharset="UTF-8">
    <fieldset>
        <p class="green info-form">Consulta de Denuncias SINADA</p>

        <div class="form-group">
            <form:label path="codigoSinada" cssClass="col-sm-1 control-label">C&oacute;digo SINADA</form:label>
            <div class="col-sm-3">
                <form:input maxlength="12" cssClass="form-control" path="codigoSinada" />
                <form:errors cssClass="help-block error" path="codigoSinada" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="nombreDenunciante" cssClass="col-sm-1 control-label">Nombre del denunciante</form:label>
            <div class="col-sm-3">
                <form:input maxlength="255" cssClass="form-control" path="nombreDenunciante" />
                <form:errors cssClass="help-block error" path="nombreDenunciante" />
            </div>
            <div class="col-sm-1"></div>
            <form:label path="nombreDenunciado" cssClass="col-sm-1 control-label">Nombre del denunciado</form:label>
            <div class="col-sm-3">
                <form:input maxlength="255" cssClass="form-control" path="nombreDenunciado" />
                <form:errors cssClass="help-block error" path="nombreDenunciado" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="razonSocialDenunciante" cssClass="col-sm-1 control-label">Raz&oacute;n Social del denunciante</form:label>
            <div class="col-sm-3">
                <form:input maxlength="255" cssClass="form-control" path="razonSocialDenunciante" />
                <form:errors cssClass="help-block error" path="razonSocialDenunciante" />
            </div>
            <div class="col-sm-1"></div>
            <form:label path="razonSocialDenunciado" cssClass="col-sm-1 control-label">Raz&oacute;n Social del denunciado</form:label>
            <div class="col-sm-3">
                <form:input maxlength="255" cssClass="form-control" path="razonSocialDenunciado" />
                <form:errors cssClass="help-block error" path="razonSocialDenunciado" />
            </div>
        </div>
        <div class="form-group">
            <label for="actividadProductivaId" class="col-sm-1 control-label">Actividad Productiva</label>
            <div class="col-sm-3">
                <form:select path="actividadProductiva" id="actividadProductivaId" cssClass="form-control">
                    <form:option value="">--- Seleccione ---</form:option>
                    <form:options items="${actividadProductivaList}" itemLabel="nombre" itemValue="codigo"/>
                </form:select>
                <form:errors cssClass="help-block error" path="actividadProductiva" />
            </div>
            <div class="col-sm-1"></div>
            <label for="estadoDenunciaId" class="col-sm-1 control-label">Estado de la denuncia</label>
            <div class="col-sm-3">
                <form:select path="estadoDenuncia" id="estadoDenunciaId" cssClass="form-control">
                    <form:option value="">--- Seleccione ---</form:option>
                    <form:options items="${estadoDenunciaList}" itemLabel="nombre" itemValue="codigo"/>
                </form:select>
                <form:errors cssClass="help-block error" path="estadoDenuncia" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="fechaInicioDenuncia" cssClass="col-sm-1 control-label">Fecha de denuncia(inicio)</form:label>
            <div class="col-sm-3">
                <form:input cssClass="form-control datepicker" path="fechaInicioDenuncia" id="fechaInicioDate" readonly="true"/>
                <form:errors cssClass="help-block error" path="fechaInicioDenuncia" />
            </div>
            <div class="col-sm-1"></div>
            <form:label path="fechaFinDenuncia" cssClass="col-sm-1 control-label">Fecha de denuncia(fin)</form:label>
            <div class="col-sm-3">
                <form:input cssClass="form-control datepicker" path="fechaFinDenuncia" id="fechaFinDate" readonly="true"/>
                <form:errors cssClass="help-block error" path="fechaFinDenuncia" />
            </div>
        </div>
        <div class="form-group">
            <label for="departamentoId" class="col-sm-1 control-label">Departamento</label>
            <div class="col-sm-2">
                <form:select path="departamento" id="departamentoId" cssClass="form-control">
                    <form:option value="">--- Seleccione ---</form:option>
                    <form:options items="${departamentoList}" itemLabel="nombre" itemValue="codigo"/>
                </form:select>
                <form:errors cssClass="help-block error" path="departamento" />
            </div>
            <label for="provinciaId" class="col-sm-1 control-label">Provincia</label>
            <div class="col-sm-2">
                <form:select path="provincia" id="provinciaId" cssClass="form-control">
                    <form:option value="">--- Seleccione ---</form:option>
                    <form:options items="${provinciaList}" itemLabel="nombre" itemValue="id.codigo"/>
                </form:select>
                <form:errors cssClass="help-block error" path="provincia" />
            </div>
            <label for="distritoId" class="col-sm-1 control-label">Distrito</label>
            <div class="col-sm-2">
                <form:select path="distrito" id="distritoId" cssClass="form-control">
                    <form:option value="">--- Seleccione ---</form:option>
                    <form:options items="${distritoList}" itemLabel="nombre" itemValue="id.codigo"/>
                </form:select>
                <form:errors cssClass="help-block error" path="distrito" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="descripcion" cssClass="col-sm-1 control-label">Texto en descripci&oacute;n</form:label>
            <div class="col-sm-8">
                <form:input maxlength="255" cssClass="form-control" path="descripcion" />
                <form:errors cssClass="help-block error" path="descripcion" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="institucion" cssClass="col-sm-1 control-label">Instituci&oacute;n competente</form:label>
            <div class="col-sm-8">
                <form:input maxlength="255" cssClass="form-control" path="institucion" />
                <form:errors cssClass="help-block error" path="institucion" />
            </div>
        </div>
        <div class="form-group">
            <label for="oficinaId" class="col-sm-1 control-label">Oficina</label>
            <div class="col-sm-3">
                <form:select path="oficina" id="oficinaId" cssClass="form-control">
                    <form:option value="">--- Todos ---</form:option>
                    <form:options items="${oficinaList}" itemLabel="nombre" itemValue="codigo"/>
                </form:select>
                <form:errors cssClass="help-block error" path="oficina" />
            </div>
            <label for="medioProbatorioId" class="col-sm-2 control-label">&iquest;Adjunt&oacute; medios probatorios en soporte digital?</label>
            <div class="col-sm-3">
                <form:select path="medioProbatorio" id="medioProbatorioId" cssClass="form-control">
                    <form:option value="">--- Seleccione ---</form:option>
                    <form:options items="${documentoList}" itemLabel="label" itemValue="value"/>
                </form:select>
                <form:errors cssClass="help-block error" path="medioProbatorio" />
            </div>
        </div>
        <br/>


        <button type="submit" class="btn btn-success">Consultar</button>
        <button type="reset" class="btn btn-success">Cancelar</button>

    </fieldset>
</form:form>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
    $(document).ready(function() {
        var defaultOption = "<option value=''>--- Seleccione ---</option>";
        $("#departamentoId").change(function() {
            var options = defaultOption;
            $.getJSON("../ubigeo/provincia", {ccdd:$(this).val()}, function(data) {
                for (var i = 0; i < data.length; i++) {
                    options += '<option value="' + data[i].id.codigo + '">' + data[i].nombre + '</option>';
                }
                $("#provinciaId").html(options);
                $("#distritoId").html(defaultOption);
            });
        });
        $("#provinciaId").change(function() {
            var options = defaultOption;
            $.getJSON("../ubigeo/distrito", {ccdd:$("#departamentoId").val(), ccpp:$(this).val()}, function(data) {
                for (var i = 0; i < data.length; i++) {
                    options += '<option value="' + data[i].id.codigo + '">' + data[i].nombre + '</option>';
                }
                $("#distritoId").html(options);
            });
        });
    });
</script>