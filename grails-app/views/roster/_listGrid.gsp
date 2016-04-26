%{--
The code for a jqgrid
--}%


<script type="text/javascript">
    $(document).ready(function() {//code goes here
        jQuery("#allRoster").jqGrid({
            heigth: 'auto', //height of the grid
            width: '1000', // width of the grid
            caption: 'Roster List', //Title for the grid
            url: 'listAllRoster', //loaction in where the data for the grid is comiing from. The controller you use to initialize the grid data.
            editurl:'editAllRoster', //same as the url command, points to the controller editAllRoster to tell the edit column what to do when editting the rows.
            datatype: "json", //the type of data processing through the grid.
            colNames: ['','Name', 'Position', 'Department', 'Location'], // The column titles you want to use for the grid
            colModel: [ //The parameters for the data going through each column.
                //This empty column is a column that holds both the edit and delete button.
                {name:'actions', index:'actions', search:false, sortable:false, title:false, editable:false, required:false, sortable:false, width:"20",
                    formatter: 'actions', hidden:false, formatoptions: {
                    keys: true, editbutton: true, delbutton: true}
                },
                {name:'name', width:200, sortable: true, formatter:'showlink',formatoptions: {baseLinkUrl:'../roster/', showAction:'show'},title:false},
                {name:'position', width:200, editable:true},
                {name:'department', width:200, editable:true},
                {name:'location', width:200,editable:false ,title:false}
            ],

            rowNum:10, //amount of rows you want to start off when the grid is called

            rowList:[10,20,40,60], //the size of the number of rows you want to hold
            gridview: true, //allows you to see the grid, not sure if absolutley neccessary
            viewrecords: true, //same for gridview
            sortname: 'name',//when grid is inialized what you want the rows to be sorted by.
            sortorder: "asc",//if the sorting order from sort name are in asceding order or not.
            autowidth:true, //the width of the column holding the data to be auto.
            forceFit:true,
            shrinkToFit: true,
            pager: '#rosterAllPager',
            scrollOffset:0,
            gridComplete: function() {
            }
        });



        // This function allows you to search the column for a specific thing you are looking for.
        jQuery('#allRoster').filterToolbar({id:'allRoster', searchOnEnter:true});
        $("#allRoster").jqGrid('navGrid','#rosterAllPager',{
                    edit:true, //If true adds edit button at the bottom of the grid. Same for add and delete
                    add:true,
                    del:false,
                    refresh:false,
                    refreshstate:"current",
                    search:false
                },
                {},
                {recreateForm:true //since clearAfterAdd is trueby default, recreate the form so we re-establish value for parent id
                });

        %{--Not sure what exactly this does--}%
        jQuery("#grid_id").jqGrid({

            pager : '#rosterAllPager',

        });
        %{--Not sure what exactly this does--}%
        jQuery("#grid_id").navGrid('#allMobileSuitsPager',"add_allMobileSuits" );



        jQuery(window).bind('resize', function() {

        }).trigger('resize');
    });



</script>


%{--tag for grid--}%
<table id="allRoster"></table>
%{--tag for pager--}%
<div id="rosterAllPager"></div>