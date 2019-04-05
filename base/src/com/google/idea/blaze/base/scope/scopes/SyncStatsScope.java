/*
 * Copyright 2019 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.idea.blaze.base.scope.scopes;

import com.google.idea.blaze.base.logging.EventLoggingService;
import com.google.idea.blaze.base.logging.utils.SyncStats;
import com.google.idea.blaze.base.scope.BlazeContext;
import com.google.idea.blaze.base.scope.BlazeScope;

/** Takes a {@link SyncStats.Builder} as input and logs the stats when the scope ends. */
public class SyncStatsScope implements BlazeScope {

  public final SyncStats.Builder stats;

  public SyncStatsScope(SyncStats.Builder stats) {
    this.stats = stats;
  }

  @Override
  public void onScopeEnd(BlazeContext context) {
    EventLoggingService.getInstance().log(stats.build());
  }
}
