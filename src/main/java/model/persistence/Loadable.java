package model.persistence;

import java.io.FileNotFoundException;

/**
 * An interface that handles saving and loading.
 */
public interface Loadable {
  /**  
   * Loads stored data.
   */
  public void loadData() throws FileNotFoundException;
}