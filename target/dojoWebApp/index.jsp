<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Tutorial: Hello Dojo!</title>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0;
            overflow:hidden;
        }
    </style>

    <script type="text/javascript">
        var dojoConfig = {
            isDebug:true,
            parseOnLoad:true,
            async: false,

            packages: [{
                name: "pages",
                location: "/dojoWebApp/pages"
            },{
                name: "gridx",
                location: "/dojoWebApp/webjars/gridx/1.3.9"
            }]
        };
    </script>
    <script type="text/javascript" src="webjars/dojo-src/1.10.4/dojo/dojo.js"></script>
    <link rel="stylesheet" href="webjars/dojo-src/1.10.4/dijit/themes/claro/claro.css" />
    <link rel="stylesheet" href="webjars/gridx/1.3.9/resources/claro/Gridx.css" />

    <script>
        require(["dojo/parser"]);
    </script>
</head>
<body class="claro">
    <div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="style:'width: 100%; height: 100%'">

        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region: 'top'" title="Top Pane">
            <div data-dojo-type="dijit/MenuBar" id="navMenu">
                <div data-dojo-type="dijit/PopupMenuBarItem">
                    <span>File</span>
                    <div data-dojo-type="dijit/DropDownMenu" id="fileMenu">
                        <div data-dojo-type="dijit/MenuItem" data-dojo-props="onClick:function(){alert('file 1');}">File #1</div>
                        <div data-dojo-type="dijit/MenuItem" data-dojo-props="onClick:function(){alert('file 2');}">File #2</div>
                    </div>
                </div>
                <div data-dojo-type="dijit/PopupMenuBarItem">
                    <span>Edit</span>
                    <div data-dojo-type="dijit/DropDownMenu" id="editMenu">
                        <div data-dojo-type="dijit/MenuItem" data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconCut',
                                    onClick:function(){alert('cut!')}">Cut</div>
                        <div data-dojo-type="dijit/MenuItem" data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconCopy',
                                    onClick:function(){alert('copy!')}">Copy</div>
                        <div data-dojo-type="dijit/MenuItem" data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconPaste',
                                    onClick:function(){alert('paste!')}">Paste</div>
                    </div>
                </div>
                <div data-dojo-type="dijit/MenuBarItem">
                    Save
                </div>
            </div>
        </div>

        <div data-dojo-type="dijit/layout/AccordionContainer" data-dojo-props="region: 'left', style:'width:15%'">
            <div data-dojo-type="pages/AccordionPane" data-dojo-props="region: 'left'"></div>
        </div>

        <div data-dojo-id="tabContainerNode" data-dojo-type="dijit/layout/TabContainer" data-dojo-props="region: 'center'">
            <div data-dojo-type="pages/MainTab" data-dojo-props="region: 'center'"></div>
        </div>
        <%--<div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region: 'bottom'">Bottom Pane</div>--%>
    </div>
</body>
</html>
