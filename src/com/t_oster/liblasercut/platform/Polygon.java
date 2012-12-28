/**
 * This file is part of VisiCut.
 * Copyright (C) 2012 Max Gaukler <development@maxgaukler.de>
 * 
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *    VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 * 
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/
package com.t_oster.liblasercut.platform;

import java.util.LinkedList;

/**
 * Polygon
 * assertions: path is closed (start=end), at least two elements
 * @see Point
 */
public class Polygon extends LinkedList<Point> {
  public boolean isClosed()  {
    return (size() >= 2) && getLast().equals(getFirst());
  }
  protected void requireClosed() {
    if (!isClosed()) {
      throw new RuntimeException("Polygon was not closed, this is necessary for certain operations");
    }
  }
  
  public boolean contains(Point p) {
    throw new RuntimeException("NYI");
  }
  
  public boolean contains(Polygon poly) {
    requireClosed();
    poly.requireClosed();
    for (Point pt: poly) {
      if (!this.contains(pt)) {
        return false;
      }
    }
    return true;
  }
}
