package com.jak.flappy.manager;

import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by manu on 01/04/14.
 */
public class ContactManager {
    private Fixture fixtureA;
    private Fixture fixtureB;

    public ContactManager(World world) {
        world.setContactListener(new MyContactListener());
    }

    public boolean hasCollided() {
        return fixtureA != null;
    }

    public void reset() {
        fixtureA = null;
        fixtureB = null;
    }

    public Fixture getFixtureB() {
        return fixtureB;
    }

    public Fixture getFixtureA() {
        return fixtureA;
    }

    private class MyContactListener implements ContactListener {

        @Override
        public void beginContact(Contact contact) {
            fixtureA = contact.getFixtureA();
            fixtureB = contact.getFixtureB();
        }

        @Override
        public void endContact(Contact contact) {

        }

        @Override
        public void preSolve(Contact contact, Manifold manifold) {

        }

        @Override
        public void postSolve(Contact contact, ContactImpulse contactImpulse) {

        }
    }
}
