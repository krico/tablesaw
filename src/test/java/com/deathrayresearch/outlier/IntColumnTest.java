package com.deathrayresearch.outlier;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class IntColumnTest {

  private IntColumn column = new IntColumn("t1", 100);


  @Test
  public void testSum() {
    for (int i = 0; i < 100; i++) {
      column.add(1);
    }
    assertEquals(100, column.sum());
  }

  @Test
  public void testIsLessThan() {
    for (int i = 0; i < 100; i++) {
      column.add(i);
    }
    assertEquals(50, column.isLessThan(50).getCardinality());
  }

  @Test
  public void testIsGreaterThan() {
    for (int i = 0; i < 100; i++) {
      column.add(i);
    }
    assertEquals(49, column.isGreaterThan(50).getCardinality());
  }

  @Test
  public void testIsGreaterThanOrEqualTo() {
    for (int i = 0; i < 100; i++) {
      column.add(i);
    }
    assertEquals(50, column.isGreaterThanOrEqualTo(50).getCardinality());
    assertEquals(50, column.isGreaterThanOrEqualTo(50).select(0));
  }

  @Test
  public void testIsLessThanOrEqualTo() {
    for (int i = 0; i < 100; i++) {
      column.add(i);
    }
    assertEquals(51, column.isLessThanOrEqualTo(50).getCardinality());
    assertEquals(49, column.isLessThanOrEqualTo(50).select(49));
  }

  @Test
  public void testIsEqualTo() {
    for (int i = 0; i < 100; i++) {
      column.add(i);
    }
    assertEquals(1, column.isEqualTo(10).getCardinality());

  }
}