/*
Copyright (C) 2008-2011 GSyC/LibreSoft, Universidad Rey Juan Carlos.

Author: Jose Antonio Santos Cadenas <jcaden@libresoft.es>
Author: Santiago Carot-Nemesio <scarot@libresoft.es>

This program is a (FLOS) free libre and open source implementation
of a multiplatform manager device written in java according to the
ISO/IEEE 11073-20601. Manager application is designed to work in
DalvikVM over android platform.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

*/

package es.libresoft.openhealth.android.aidl.types;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class ITypeVerList implements Parcelable {
	private List<ITypeVer> values = null;

	public static final Parcelable.Creator<ITypeVerList> CREATOR =
			new Parcelable.Creator<ITypeVerList>() {
		public ITypeVerList createFromParcel(Parcel in) {
			return new ITypeVerList(in);
		}

		public ITypeVerList[] newArray(int size) {
			return new ITypeVerList[size];
		}
	};

	public ITypeVerList () {

	}

	private ITypeVerList (Parcel in) {
		readFromParcel(in);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(values);
	}

	public void readFromParcel(Parcel in) {
		java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
		if (values == null)
			values = new ArrayList<ITypeVer>();
		in.readList(values, cl);
	}

	public ITypeVerList (List<ITypeVer> values) {
		this.values = values;
	}

	public List<ITypeVer> getValues() {
		return values;
	}

	public void setValues(List<ITypeVer> values) {
		this.values = values;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ITypeVerList))
			return false;
		ITypeVerList other = (ITypeVerList) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str = "";
		for (ITypeVer typeVer : values) {
			if (str != "") str += "\n";
			str += "[" + typeVer.toString() + "]";
		}
		return str;
	}
}
