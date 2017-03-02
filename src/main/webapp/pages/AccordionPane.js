define([
    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/on",
    "dojo/json",
    "dojo/store/JsonRest",
    "dijit/layout/ContentPane",
    "dijit/Tree",
    "dojo/store/Memory",
    "dijit/tree/ObjectStoreModel",
    "dijit/tree/ForestStoreModel",
    "dojo/data/ObjectStore"
], function (
    declare,
    lang,
    on,
    JSON,
    JsonRest,
    ContentPane,
    Tree,
    Memory,
    ObjectStoreModel,
    ForestStoreModel,
    ObjectStore
){
    return declare("AccordionPane", [ContentPane], {
        _createBtn: null,

        postMixInProperties: function(){
            this.inherited(arguments);
            this.title = "Documents";
        },

        postCreate: function () {
            this.addChild(this._createTree())
        },

        _createTree: function () {
            var data = new JsonRest({
                target: "/dojoWebApp/api/ecm/folders",
            });

            /*var storeMem = new Memory({
                data: [JSON.parse(data)],
                getChildren: function (object) {
                    return object.children || [];
                }
            });*/

            var storeModel = new ObjectStoreModel({
                store: data,
                query: {id: 'root'},
                mayHaveChildren: function (item) {
                    return "children" in item;
                }
            });


            // Create the Tree.
            var tree = new Tree({
                model: storeModel,
                onOpenClick: true
            });

            //tree.placeAt(win.body());

            return tree;
        }

    })
})