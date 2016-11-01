package db.customtypes;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

import model.Position;

public class PositionCompositeType implements CompositeUserType {

	public Object assemble(Serializable arg0, SessionImplementor arg1, Object arg2) throws HibernateException {
		return deepCopy(arg0);
	}

	public Object deepCopy(Object arg0) throws HibernateException {
		if(arg0 != null) {
			Position position = ((Position) arg0);
			return new Position(position.getLatitude(), position.getLongitude());
		}
		return null;
	}

	public Serializable disassemble(Object arg0, SessionImplementor arg1) throws HibernateException {
		Object  deepCopy = deepCopy(arg0);
        if(!(deepCopy instanceof Serializable)) {
            return (Serializable) deepCopy;
        }
        return null;
	}

	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		if(arg0 == null && arg1 == null) {
			return true;
		}
		if(arg0 == null || arg1 == null) {
			return false;
		}
		return arg0.equals(arg1);
	}

	public String[] getPropertyNames() {
		return new String[] {"latitude", "longitude"};
	}

	public Type[] getPropertyTypes() {
		return new Type[] {
				org.hibernate.type.StandardBasicTypes.DOUBLE,
				org.hibernate.type.StandardBasicTypes.DOUBLE
		};
	}

	public Object getPropertyValue(Object arg0, int arg1) throws HibernateException {
		if(arg0 == null) {
			return null;
		} else if (arg1 == 0) {
			return ((Position) arg0).getLatitude();
		} else if (arg1 == 1) {
			return ((Position) arg0).getLongitude();
		}
		return null;
	}

	public int hashCode(Object arg0) throws HibernateException {
		if(arg0 != null) {
			return arg0.hashCode();
		}
		return 0;
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3)
			throws HibernateException, SQLException {
		String latitude = arg0.getString(arg1[0]);
		String longitude = arg0.getString(arg1[1]);
		if(latitude != null && longitude != null) {
			Position position = new Position();
			position.setLatitude(Double.parseDouble(latitude));
			position.setLongitude(Double.parseDouble(longitude));
			return position;
		}
		return null;
	}

	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3)
			throws HibernateException, SQLException {
		if(arg1 != null) {
			arg0.setDouble(arg2, ((Position) arg1).getLatitude());
			arg0.setDouble(arg2 +1, ((Position) arg1).getLongitude());
		} else {
			arg0.setString(arg2, null);
			arg0.setString(arg2 + 1, null);
		}
		
	}

	public Object replace(Object arg0, Object arg1, SessionImplementor arg2, Object arg3) throws HibernateException {
		return deepCopy(arg0);
	}

	public Class<Position> returnedClass() {
		return Position.class;
	}

	public void setPropertyValue(Object arg0, int arg1, Object arg2) throws HibernateException {
		if(arg0 != null) {
			if(arg1 == 0) {
				((Position) arg0).setLatitude((Double) arg2);
			} else if(arg1 == 1) {
				((Position) arg0).setLongitude((Double) arg2);
			}
		}
		
	}

}
