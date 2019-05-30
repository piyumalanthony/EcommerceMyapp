package com.example.ecommercemyapp;

import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ArViewActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private String name="model";
    private String link="https://quantummechanicsdepth.000webhostapp.com/";
    private String ASSET_3D="";
    private String modelFetchName="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_view);

        // get specific model details which selected
        modelFetchName=getIntent().getStringExtra("productNameForFetch");

        ASSET_3D= link +modelFetchName+"/"+ name + ".gltf";

        //create AR fragment to render the 3D model
        arFragment= (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) ->{
            placeModel(hitResult.createAnchor());
        } );
    }

    //render model on the given anchor node
    private void placeModel(Anchor anchor) {

        ModelRenderable
                .builder()
                .setSource(this, RenderableSource
                        .builder()
                        .setSource(this, Uri.parse(ASSET_3D), RenderableSource.SourceType.GLTF2)
                        .setScale(0.90f)
                        .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                        .build()

                ).setRegistryId(ASSET_3D)
                .build()
                .thenAccept(modelRenderable -> addNodeToScene(modelRenderable,anchor))
                .exceptionally(throwable -> {
                    AlertDialog.Builder builder= new AlertDialog.Builder(this);
                    builder.setMessage(throwable.getMessage()).show();
                    return null;

                });
    }
    private void addNodeToScene(ModelRenderable modelRenderable, Anchor anchor) {

        //create anchor node and transformable node for 3D model
        AnchorNode anchorNode= new AnchorNode(anchor);
        TransformableNode transformableNode=new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();
    }


}
