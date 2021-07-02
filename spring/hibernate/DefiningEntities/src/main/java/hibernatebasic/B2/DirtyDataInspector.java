package hibernatebasic.B2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import hibernatebasic.entity.FootballPlayer;

public class DirtyDataInspector extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -998504838288921920L;

	private static final ArrayList<FootballPlayer> arrayList = new ArrayList<FootballPlayer>();

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		arrayList.add((FootballPlayer) entity);
		return true;
	}

	public static List<FootballPlayer> getListDirtyEntity() {
		return arrayList;
	}

	public static void clearDirtyEntitites() {
		arrayList.clear();
	}
}
