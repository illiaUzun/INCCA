/*===============================================================================
Copyright (c) 2016-2018 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.vuforia.engine.SampleApplication.utils;

import java.nio.Buffer;

/**
 * This class contains all the information needed to augment a teapot model
 */
public class Plane extends MeshObject {

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;


    public Plane() {
        setVerts();
        setTexCoords();
        setNorms();
        setIndices();
    }


    private void setVerts() {
        double[] PLANE_VERTS = {
                -50.130548f, -30.0f, 0.0001f,
                50.130548f, -30.0f, 0.0001f,
                50.130548f, 30.0f, 0.0001f,
                -50.130548f, 30.0f, 0.0001f};
        mVertBuff = fillBuffer(PLANE_VERTS);
        verticesNumber = PLANE_VERTS.length / 3;
    }


    private void setTexCoords() {
        double[] PLANE_TEX_COORDS = {
                0.0f, 0.0f,
                1.0f, 0.0f,
                1.0f, 1.0f,
                0.0f, 1.0f};
        mTexCoordBuff = fillBuffer(PLANE_TEX_COORDS);

    }


    private void setNorms() {
        double[] PLANE_NORMS = {
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f};
        mNormBuff = fillBuffer(PLANE_NORMS);
    }


    private void setIndices() {
        short[] PLANE_INDICES = {0, 1, 2, 0, 2, 3};
        mIndBuff = fillBuffer(PLANE_INDICES);
        indicesNumber = PLANE_INDICES.length;
    }


    public int getNumObjectIndex() {
        return indicesNumber;
    }


    @Override
    public int getNumObjectVertex() {
        return verticesNumber;
    }


    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType) {
        Buffer result = null;
        switch (bufferType) {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
            default:
                break;

        }

        return result;
    }

}
