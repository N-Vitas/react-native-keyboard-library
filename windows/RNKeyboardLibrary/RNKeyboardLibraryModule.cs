using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Keyboard.Library.RNKeyboardLibrary
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNKeyboardLibraryModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNKeyboardLibraryModule"/>.
        /// </summary>
        internal RNKeyboardLibraryModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNKeyboardLibrary";
            }
        }
    }
}
