/*******************************************************************************
 * DARPA XDATA licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with 
 * the License.  You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  
 * limitations under the License.
 * 
 * Copyright 2013 Raytheon BBN Technologies Corp.  All Rights Reserved. 
 ******************************************************************************/


package com.bbn.xdata.bitcoin;

public abstract class AbstractTransactionFilter implements TransactionFilter {

	
	/** Returns true if this filter accepts the transaction t; false otherwise.
	 * 
	 * @param t
	 * @return
	 */
	public boolean accept( BitCoinTransaction t ) {
		return true;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toString( ) {
		return "Accept-All Transaction Filter";
	}
}
