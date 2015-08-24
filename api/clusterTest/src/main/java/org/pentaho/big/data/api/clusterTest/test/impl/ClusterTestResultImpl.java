/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2015 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.big.data.api.clusterTest.test.impl;

import org.pentaho.big.data.api.clusterTest.test.ClusterTest;
import org.pentaho.big.data.api.clusterTest.test.ClusterTestEntrySeverity;
import org.pentaho.big.data.api.clusterTest.test.ClusterTestResult;
import org.pentaho.big.data.api.clusterTest.test.ClusterTestResultEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bryan on 8/12/15.
 */
public class ClusterTestResultImpl implements ClusterTestResult {
  private final ClusterTest clusterTest;
  private final List<ClusterTestResultEntry> clusterTestResultEntries;
  private final ClusterTestEntrySeverity maxSeverity;
  private final long timeTaken;

  public ClusterTestResultImpl( ClusterTest clusterTest, List<ClusterTestResultEntry> clusterTestResultEntries,
                                long timeTaken ) {
    this.clusterTest = clusterTest;
    this.clusterTestResultEntries = Collections.unmodifiableList( new ArrayList<>( clusterTestResultEntries ) );
    this.timeTaken = timeTaken;
    this.maxSeverity = ClusterTestEntrySeverity.maxSeverityEntry( clusterTestResultEntries );
  }

  @Override public ClusterTestEntrySeverity getMaxSeverity() {
    return maxSeverity;
  }

  @Override public List<ClusterTestResultEntry> getClusterTestResultEntries() {
    return clusterTestResultEntries;
  }

  @Override public ClusterTest getClusterTest() {
    return clusterTest;
  }

  @Override public long getTimeTaken() {
    return timeTaken;
  }

  //OperatorWrap isn't helpful for autogenerated methods
  //CHECKSTYLE:OperatorWrap:OFF
  @Override public String toString() {
    return "ClusterTestResultImpl{" +
      "clusterTest=" + clusterTest +
      ", clusterTestResultEntries=" + clusterTestResultEntries +
      ", maxSeverity=" + maxSeverity +
      ", timeTaken=" + timeTaken +
      '}';
  }
  //CHECKSTYLE:OperatorWrap:ON
}
