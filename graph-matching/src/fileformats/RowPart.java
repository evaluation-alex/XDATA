/*
# DARPA XDATA licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with 
# the License.  You may obtain a copy of the License at 
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software 
# distributed under the License is distributed on an "AS IS" BASIS, 
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and  
# limitations under the License.
#
# Copyright 2013 Raytheon BBN Technologies Corp.  All Rights Reserved. 
#
*/

package fileformats;

import java.io.*;
import org.apache.hadoop.io.*;

public class RowPart implements Writable {
	public int row;
	public int colBlock;
	public double[] vals;
	public int length;

	public RowPart () {row = -1; colBlock = -1; length = 0; vals = new double[length];}
	public RowPart (int r, int cBlock, int l) {row = r; colBlock = cBlock; length = l; vals = new double[length];}
	
	public void set (int r, int cBlock, int l) {
		row = r; 
		colBlock = cBlock; 
		
		if (l > length) {
			vals = new double[l];
		}
		
		length = l;
	}
	
	public void put(int i, double v) {vals[i] = v;}
	public double get(int i) {return vals[i];}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		row = in.readInt();
		colBlock = in.readInt();
		length = in.readInt();
		
		vals = new double[length];
		
		for (int i = 0; i < length; i++) {
			vals[i] = in.readDouble();
		}
		
	}

	@Override
	public void write (DataOutput out) throws IOException {
		out.writeInt(row);
		out.writeInt(colBlock);
		out.writeInt(length);
		
		for (int i = 0; i < length; i++) {
			out.writeDouble(vals[i]);
		}
	}
}