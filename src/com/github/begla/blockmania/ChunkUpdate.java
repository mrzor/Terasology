/*
 * Copyright 2011 Benjamin Glatzel <benjamin.glatzel@me.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.github.begla.blockmania;

/**
 *
 * @author Benjamin Glatzel <benjamin.glatzel@me.com>
 */
public class ChunkUpdate implements Comparable<ChunkUpdate> {
    
    private boolean _updateNeighbors;
    private Chunk _chunk;
    private byte _priority;

    /**
     * 
     * @param _updateNeighbors
     * @param _chunk
     * @param priority  
     */
    public ChunkUpdate(boolean _updateNeighbors, Chunk _chunk, byte priority) {
        this._updateNeighbors = _updateNeighbors;
        this._chunk = _chunk;
        
        if (priority <= 0) {
            priority = 1;
        }
        
        this._priority = priority;
    }

    /**
     * 
     * @param _updateNeighbors
     * @param _chunk 
     */
    public ChunkUpdate(boolean _updateNeighbors, Chunk _chunk) {
        this._updateNeighbors = _updateNeighbors;
        this._chunk = _chunk;
        this._priority = 1;
    }

    /**
     * 
     * @return
     */
    public boolean isUpdateNeighbors() {
        return _updateNeighbors;
    }

    /**
     * 
     * @return
     */
    public Chunk getChunk() {
        return _chunk;
    }

    /**
     * 
     * @return 
     */
    public byte getPriority() {
        return _priority;
    }

    /**
     * 
     * @return 
     */
    public double getWeight() {
        return _chunk.calcDistanceToPlayer() / (double) _priority;
    }
    
    /**
     * 
     * @param o
     * @return
     */
    @Override
    public int compareTo(ChunkUpdate o) {
        return new Double(getWeight()).compareTo(o.getWeight());
    }
}