package pe.gob.oefa.efa.dao.impl;

import oracle.jdbc.OracleTypes;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.oefa.efa.dao.DenunciaAmbientalesDAO;
import pe.gob.oefa.efa.model.Denuncia;
import pe.gob.oefa.efa.form.DenunciaForm;
import pe.gob.oefa.efa.model.*;
import pe.gob.oefa.efa.utils.ConnectionManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgonzales on 04/12/2014.
 */
@Repository
public class DenunciaAmbientalesDAOImpl implements DenunciaAmbientalesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Denuncia> obtenerDenuncias(DenunciaForm form) {
        List<Denuncia> denuncias = new ArrayList<Denuncia>();
        CallableStatement callableStatement = null;
        Connection connection = null;
        try {
            String storeProcedure = "{CALL SIGEFA.PK_DENUNCIA.SP_LISTA_DENUNCIA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            connection = ConnectionManager.getConnection();
            callableStatement = connection.prepareCall(storeProcedure);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.setString(2, form.getCodigoSinada());
            callableStatement.setString(3, form.getNombreDenunciante());
            callableStatement.setString(4, form.getNombreDenunciado());
            callableStatement.setString(5, form.getRazonSocialDenunciante());
            callableStatement.setString(6, form.getRazonSocialDenunciado());
            callableStatement.setString(7, "085");
            callableStatement.setString(8, form.getDepartamento());
            callableStatement.setString(9, form.getProvincia());
            callableStatement.setString(10, form.getDistrito());
            callableStatement.setString(11, form.getFechaInicioDenuncia());
            callableStatement.setString(12, form.getFechaFinDenuncia());
            callableStatement.setString(13, form.getActividadProductiva());
            callableStatement.setString(14, form.getEstadoDenuncia());
            callableStatement.setString(15, form.getDescripcion());
            callableStatement.setString(16, form.getOficina());
            callableStatement.setString(17, form.getInstitucion());
            callableStatement.setString(18, form.getMedioProbatorio());

            callableStatement.execute();

            ResultSet rs = (ResultSet)callableStatement.getObject(1);
            Denuncia denuncia;
            while(rs.next()) {
                denuncia = new Denuncia();
                denuncia.setIdDenuncia(rs.getString("ID_DENUNCIA"));
                denuncia.setCodigoSinada(rs.getString("C_SINADA"));
                denuncia.setDescHecho(rs.getString("DESC_HECHO"));
                denuncia.setFechaDenuncia(rs.getString("FECHA_DENUNCIA"));
                denuncia.setFechaRegistro(rs.getString("F_REGISTRO"));
                denuncia.setFechaModificacion(rs.getString("F_MODIFICACION"));
                denuncia.setDenunciante(rs.getString("DENUNCIANTE"));
                denuncia.setDenunciado(rs.getString("DENUNCIADO"));
                denuncia.setRazonSocialDenunciante(rs.getString("RSOCIAL_DENUNCIANTE"));
                denuncia.setRazonSocialDenunciado(rs.getString("RSOCIAL_DENUNCIADO"));
                denuncia.setEstado(rs.getString("ESTADO"));
                denuncia.setNombreEstado(rs.getString("NOM_ESTADO"));
                denuncia.setVerDenunciante(rs.getString("VER_DENUNCIANTE"));
                denuncias.add(denuncia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (callableStatement != null) {
                    callableStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e) { e.printStackTrace(); }
        }

        return denuncias;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Oficina> obtenerOficinas() {
        return getSession().createQuery("from Oficina").list();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ActividadProductiva> obtenerActividadProductiva() {
        return getSession().createQuery("from ActividadProductiva").list();
    }

    public List<EstadoDenuncia> obtenerEstadoDenuncia() {
        List<EstadoDenuncia> lista = new ArrayList<EstadoDenuncia>();
        lista.add(new EstadoDenuncia("1 ","En Seguimiento"));
        lista.add(new EstadoDenuncia("2 ","En Expediente"));
        lista.add(new EstadoDenuncia("5 ","Derivado 1"));
        lista.add(new EstadoDenuncia("6 ","Comunicación 1"));
        lista.add(new EstadoDenuncia("7 ","Con Respuesta 1"));
        lista.add(new EstadoDenuncia("8 ","Comunicación 2"));
        lista.add(new EstadoDenuncia("9 ","Derivado 2"));
        lista.add(new EstadoDenuncia("10","Con Respuesta 2"));
        lista.add(new EstadoDenuncia("11","Comunicación 3"));
        lista.add(new EstadoDenuncia("12","Derivado 3"));
        lista.add(new EstadoDenuncia("13","Con Respuesta 3"));
        lista.add(new EstadoDenuncia("14","Comunicación 4"));
        lista.add(new EstadoDenuncia("3 ","Atendido"));
        lista.add(new EstadoDenuncia("15","Archivado"));
        return lista;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
